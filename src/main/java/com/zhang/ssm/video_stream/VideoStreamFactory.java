package com.zhang.ssm.video_stream;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
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

    private final List<VideoStreamConverter> videoStreamConverters = new LinkedList<VideoStreamConverter>();

    private final ExecutorService executorService = Executors.newFixedThreadPool(11);


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
            recorder = FFmpegFrameRecorder.createDefault(dest, width, height);
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
            LOGGER.error("create new recorder failed" + e.getMessage());
        }
        recorder.setVideoCodec(videoCodec);
        recorder.setFormat(format);
        recorder.setFrameRate(frameRate);
        recorder.setGopSize(gopSize);
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

    public OpenCVFrameConverter.ToIplImage createConverter() {
        return new OpenCVFrameConverter.ToIplImage();
    }

    public VideoStreamConverter createVideoStreamConverter(String lineName, FrameGrabber grabber, FrameRecorder recorder, OpenCVFrameConverter.ToIplImage converter) {
        for (VideoStreamConverter v : this.videoStreamConverters) {
            if (v.getLineName().equals(lineName)) {
                LOGGER.info("该线路已存在，若想添加新线路，请先删除原线路");
                return v;
            }
        }
        VideoStreamConverter nv = new VideoStreamConverter(grabber, recorder, converter, lineName);
        this.videoStreamConverters.add(nv);
        return nv;
    }

    public boolean delVideoStreamConverter(String lineName) {
        for (VideoStreamConverter v : this.videoStreamConverters) {
            if (v.getLineName().equals(lineName)) {
                v.stopAddRelease();
                this.videoStreamConverters.remove(v);
                LOGGER.info("该线路已删除");
                return true;
            }
        }
        LOGGER.info("该线路不存在");
        return false;
    }

    public void addNewLine(StartExecThread pushStream) {
        this.executorService.execute(pushStream);
        LOGGER.info("新线路开始执行");
    }

    public boolean checkAllSource() {
        for (VideoStreamConverter v : this.videoStreamConverters) {
            if (!v.tryGetFirstFrame()) {
                LOGGER.error(v.getLineName() + "--" + "提取源失败，请检查设备");
                return false;
            }
        }
        LOGGER.info("所有设备均能正常取源");
        return true;
    }

    public boolean startAllConverter() {
        for (VideoStreamConverter v : this.videoStreamConverters) {
            if (!v.isOpened()) {
                addNewLine(new StartExecThread(v));
                LOGGER.error(v.getLineName() + "--" + "启动推流失败，请检查该节点");
                return false;
            }
        }
        LOGGER.info("所有设备均推流正常");
        return true;


    }

    public boolean startPreparing(){
        for (VideoStreamConverter v : this.videoStreamConverters) {
            if (!v.startGrabber() || !v.startRecorder()) {
                LOGGER.error(v.getLineName() + "--" + "该线路连接失败，请检查该节点");
                return false;
            }
        }
        LOGGER.info("所有线路均连接正常");
        return true;
    }





}
