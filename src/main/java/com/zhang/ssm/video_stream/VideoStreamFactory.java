package com.zhang.ssm.video_stream;

import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.utils.DateUtil;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName VideoStreamFactory
 * @Description: 生成转流器必要的组件对象的工厂
 * @Author Raymond Zhang
 * @Date 2018/6/5 14:16
 * @Version 1.0
 **/
public class VideoStreamFactory {
    private static String AB_IMG_PATH_PREFIX = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoStreamFactory.class);

    private static volatile VideoStreamFactory videoStreamFactory;

    private Map<String, VideoStreamConverter> videoStreamConverterMaps = new HashMap<String, VideoStreamConverter>();

    private ExecutorService executorService = Executors.newFixedThreadPool(11);

    private Queue<AbnormalInfo> abFrames = new LinkedBlockingQueue<AbnormalInfo>();

    private Map<String, String> savePaths = new HashMap<String, String>(128);

    private VideoStreamFactory() {
    }

    public static VideoStreamFactory getInstance() {
        if (videoStreamFactory == null) {
            synchronized (VideoStreamFactory.class) {
                if (videoStreamFactory == null) {
                    videoStreamFactory = new VideoStreamFactory();
                }
            }
        }
        return videoStreamFactory;
    }

    public FrameRecorder createDefaultRecorder(String dest) {
        return createRecorder(dest, 1920, 1080, avcodec.AV_CODEC_ID_H264,
                "flv", 25, 25);
    }

    public FrameRecorder createRecorder(String dest, int width, int height, int videoCodec, String format, int frameRate, int gopSize) {
        FrameRecorder recorder = null;
        try {
            recorder = FrameRecorder.createDefault(dest, width, height);
            recorder.setVideoCodec(videoCodec);
            recorder.setFormat(format);
            recorder.setFrameRate(frameRate);
            recorder.setGopSize(gopSize);
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
            LOGGER.error("create new recorder failed" + e.getMessage());
        }
        return recorder;
    }

    public FrameGrabber createDefaultGrabber(String src) {
        return createGrabber(src, "tcp");
    }

    public FrameGrabber createGrabber(String src, String udp_tcp) {
        FrameGrabber grabber = null;
        try {
            grabber = FFmpegFrameGrabber.createDefault(src);
            grabber.setOption("rtsp_transport", udp_tcp);
        } catch (FrameGrabber.Exception e) {
            LOGGER.error("create new Grabber failed" + e.getMessage());
        }
        return grabber;
    }

    public OpenCVFrameConverter.ToIplImage createImgConverter() {
        return new OpenCVFrameConverter.ToIplImage();
    }

    public VideoStreamConverter createVideoStreamConverter(String lineName, FrameGrabber grabber, FrameRecorder recorder, OpenCVFrameConverter.ToIplImage converter) {

        if (videoStreamConverterMaps.containsKey(lineName)) {
            LOGGER.info("该线路已存在，若想添加新线路，请先删除原线路");
            return videoStreamConverterMaps.get(lineName);
        }

        VideoStreamConverter nv = new VideoStreamConverter(grabber, recorder, converter, lineName);
        videoStreamConverterMaps.put(lineName, nv);
        return nv;
    }

    public boolean delVideoStreamConverter(String lineName) {
        VideoStreamConverter v = null;
        if (videoStreamConverterMaps.containsKey(lineName) && (v = videoStreamConverterMaps.get(lineName)) != null) {
            v.stopAddRelease();
            videoStreamConverterMaps.remove(lineName);
            LOGGER.info("该线路已删除");
            return true;
        }
        LOGGER.error("该线路删除失败,不存在相对应的连接");
        return false;
    }

    public void addNewLine(StartExecThread pushStream) {
        this.executorService.execute(pushStream);
        LOGGER.info("新线路开始执行");
    }

    public boolean checkAllSource() {
        for (VideoStreamConverter v : videoStreamConverterMaps.values()) {
            if (!v.tryGetFirstFrame()) {
                LOGGER.error(v.getLineName() + "--" + "提取源失败，请检查设备");
                return false;
            }
        }
        LOGGER.info("所有设备均能正常取源");
        return true;
    }

    public boolean startAllPush() {
        for (VideoStreamConverter v : videoStreamConverterMaps.values()) {
            if (!v.isOpened()) {
                addNewLine(new StartExecThread(v));
                LOGGER.error(v.getLineName() + "--" + "启动推流失败，请检查该节点");
                return false;
            }
        }
        LOGGER.info("所有设备均推流正常");
        return true;


    }

    public boolean startPreparing() {
        for (VideoStreamConverter v : videoStreamConverterMaps.values()) {
            if (!v.startGrabber() || !v.startRecorder()) {
                LOGGER.error(v.getLineName() + "--" + "该线路启用连接失败，请检查该节点");
                return false;
            }
        }
        LOGGER.info("所有线路均连接正常");
        return true;
    }

    public boolean makeSaveDirs() {
        String date = DateUtil.genTime(new Date(), "yyyy-MM-dd");
        File dir = new File(AB_IMG_PATH_PREFIX + File.separator + date);
        try {
            if (!(dir.exists() && dir.isDirectory())) {
                dir.mkdir();
            }
            for (String lineName : videoStreamConverterMaps.keySet()) {
                String saveDir = dir + File.separator + lineName;
                File sDir = new File(saveDir);
                if (!(sDir.exists() && sDir.isDirectory())) {
                    sDir.mkdir();
                    savePaths.put(lineName, saveDir);
                }
            }
        } catch (Exception e) {
            LOGGER.error("存储异常图片的路径创建失败" + e.getMessage());
            return false;
        }
        return true;
    }


    public VideoStreamConverter getConverter(String lineName) {
        return videoStreamConverterMaps.get(lineName);
    }

}
