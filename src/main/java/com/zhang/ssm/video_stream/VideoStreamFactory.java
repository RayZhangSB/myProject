package com.zhang.ssm.video_stream;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName VideoStreamFactory
 * @Description: 生成转流器必要的组件对象的工厂
 * @Author Raymond Zhang
 * @Date 2018/6/5 14:16
 * @Version 1.0
 **/
public class VideoStreamFactory {


    private static final Logger LOGGER = LoggerFactory.getLogger(VideoStreamFactory.class);

    private static volatile VideoStreamFactory videoStreamFactory;

    private Map<String, VideoStreamConverter> videoStreamConverterMaps = new ConcurrentHashMap<String, VideoStreamConverter>(16);

    private ExecutorService executorService = Executors.newFixedThreadPool(12);


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

    public void delVideoStreamConverter(String lineName) {
        VideoStreamConverter v;
        if (videoStreamConverterMaps.containsKey(lineName) && (v = videoStreamConverterMaps.get(lineName)) != null) {
            v.stopAndRelease();
            videoStreamConverterMaps.remove(lineName);
            LOGGER.info("该线路已删除");
        } else {
            LOGGER.error("该线路删除失败,不存在相对应的连接");
        }
    }

    public String addNewLine(VideoStreamConverter v) {
        String name = v.getLineName();
        if (v.isRunning()) {
            return "line" + name + "have started;";
        }
        boolean b1 = v.startGrabber();
        boolean b2 = v.startRecorder();
        if (!b1) {
            LOGGER.info("grabber start error");
        }
        if (!b2) {
            LOGGER.info("recorder start error");
        }
        String msg;
        if (b1 && b2) {
            this.executorService.execute(new StartExecThread(v));
            LOGGER.info("新线路开始执行");
            msg = name + "start  success;";
        } else {
            msg = "start  failed,please check " + name + " is correct;";
        }
        return msg;


    }

    /*
    在未启动之前，对每条线路做抓帧测试
     */
    public List<String> checkSourceByGrab() {
        List<String> failedLines = new ArrayList<String>();
        for (VideoStreamConverter v : videoStreamConverterMaps.values()) {
            if (!v.tryGetFirstFrame()) {
                LOGGER.info(v.getLineName() + "can‘t grab correct");
                failedLines.add(v.getLineName());
            }
        }
        return failedLines;
    }

    public String startAllPush() {
        StringBuilder msg = new StringBuilder();
        for (VideoStreamConverter v : videoStreamConverterMaps.values()) {
            msg.append(addNewLine(v));
        }
        return msg.toString();
    }


    public VideoStreamConverter getConverter(String lineName) {
        return videoStreamConverterMaps.get(lineName);
    }

    public void stopAllPush() {
        for (VideoStreamConverter v : videoStreamConverterMaps.values()) {
            if (v != null)
                v.stop();
        }
    }

    public void releaseAllPush() {
        for (String name : videoStreamConverterMaps.keySet()) {
            release(name);
        }
    }


    public void addConverterToMap(String lineName, String rtspPath, String rtmpPath) {
        FrameGrabber grabber = videoStreamFactory.createDefaultGrabber(rtspPath);
        FrameRecorder recorder = videoStreamFactory.createDefaultRecorder(rtmpPath);
        OpenCVFrameConverter.ToIplImage converter = videoStreamFactory.createImgConverter();
        VideoStreamConverter videoStreamConverter = videoStreamFactory.createVideoStreamConverter(lineName, grabber, recorder, converter);
        videoStreamConverterMaps.put(lineName, videoStreamConverter);
    }


    public void release(String lineName) {
        VideoStreamConverter v = videoStreamConverterMaps.get(lineName);
        if (v != null && v.stopAndRelease()) {
            videoStreamConverterMaps.remove(v.getLineName());
//            LineConfig.removeLineMap(v.getLineName());
        }
    }

    public void stop(String lineName) {
        VideoStreamConverter v = videoStreamConverterMaps.get(lineName);
        if (v != null) {
            v.stop();
        }
    }

    public Map<String, VideoStreamConverter> getMap() {
        return videoStreamConverterMaps;
    }


}
