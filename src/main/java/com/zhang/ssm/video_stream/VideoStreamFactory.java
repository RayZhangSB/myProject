package com.zhang.ssm.video_stream;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final Map<String, VideoStreamConverter> videoStreamConverterMap = new ConcurrentHashMap(256);

    private final ExecutorService executorService = Executors.newFixedThreadPool(15);


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

    public FrameRecorder createDefaultRecorder(String rtmpPath) {
        return createRecorder(rtmpPath, 1920, 1080, avcodec.AV_CODEC_ID_H264,
                "flv", 25, 25);
    }

    /*
    outputfile = rtmp://ip:port/live1
    avcodec.AV_CODEC_ID_H264  "flv"
     */
    public FrameRecorder createRecorder(String outputFile, int width, int height, int videoCodec, String format, int frameRate, int gopSize) {
        FrameRecorder recorder = null;
        try {
            recorder = FrameRecorder.createDefault(outputFile, width, height);
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e2) {
            LOGGER.error("create new recorder failed" + e2.getMessage());
        }
        recorder.setVideoCodec(videoCodec);
        recorder.setFormat(format);
        recorder.setFrameRate(frameRate);
        recorder.setGopSize(gopSize);
        return recorder;
    }

    public FrameGrabber createDefaultGrabber(String inputFile, String udp_tcp) {
        FrameGrabber grabber = null;
        try {
            grabber = FFmpegFrameGrabber.createDefault(inputFile);
        } catch (FrameGrabber.Exception e) {
            LOGGER.error("create new Grabber failed" + e.getMessage());
        }
        grabber.setOption("rtsp_transport", udp_tcp);
        return grabber;
    }


    public OpenCVFrameConverter.ToIplImage createConverter() {
        return new OpenCVFrameConverter.ToIplImage();
    }

    public VideoStreamConverter createVideoStreamConverter(String lineName, FrameGrabber grabber, FrameRecorder recorder, OpenCVFrameConverter.ToIplImage converter) {
        VideoStreamConverter v = new VideoStreamConverter(grabber, recorder, converter);
        if (this.videoStreamConverterMap.containsKey(lineName)) {
            return getVideoStreamConverter(lineName);
        }
        this.videoStreamConverterMap.put(lineName, v);
        return v;
    }

    public VideoStreamConverter getVideoStreamConverter(String lineName) {
        if (!this.videoStreamConverterMap.containsKey(lineName)) {
            LOGGER.error("该线路不存在，请先构建新的线路");
        }
        return this.videoStreamConverterMap.get(lineName);
    }

    public void addLine(ExecPushStream pushStream) {
        this.executorService.execute(pushStream);
    }

}
