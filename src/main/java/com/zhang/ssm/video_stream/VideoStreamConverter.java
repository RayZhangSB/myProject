package com.zhang.ssm.video_stream;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName VideoStreamConverter
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/5 16:37
 * @Version 1.0
 **/
public class VideoStreamConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoStreamConverter.class);
    private String lineName;
    private FrameRecorder recorder;
    private FrameGrabber grabber;
    private OpenCVFrameConverter.ToIplImage converter;
    private boolean isOpened = false;

    public VideoStreamConverter(FrameGrabber grabber, FrameRecorder recorder, OpenCVFrameConverter.ToIplImage converter, String lineName) {
        this.recorder = recorder;
        this.grabber = grabber;
        this.converter = converter;
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }

    public boolean isOpened() {
        return isOpened;
    }


    public void startRecorder() {
        try {
            recorder.start();
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
            try {
                LOGGER.info("录制器启动失败，正在重新启动...");
                if (recorder != null) {
                    LOGGER.info("正在尝试关闭录制器...");
                    recorder.stop();
                    LOGGER.info("正在尝试重新开启录制器...");
                    recorder.start();
                }
            } catch (org.bytedeco.javacv.FrameRecorder.Exception e1) {
                LOGGER.error("录制器启动失败--" + e1.getMessage());
            }
        }
    }

    public boolean tryGetFirstFrame() {
        Frame grabFrame = null;
        try {
            grabFrame = grabber.grab();
        } catch (FrameGrabber.Exception e) {
            return false;
        }
        return grabFrame != null;
    }

    public boolean startPushStream() {
        Loader.load(opencv_objdetect.class);
        long startTime = 0;
        Frame grabFrame = null;
        opencv_core.IplImage grabbedImage = null;
        try {
            while ((grabFrame = grabber.grab()) != null) {
                isOpened = true;
                grabbedImage = converter.convert(grabFrame);
                Frame rotatedFrame = converter.convert(grabbedImage);
                if (startTime == 0) {
                    startTime = System.currentTimeMillis();
                }
                recorder.setTimestamp(1000 * (System.currentTimeMillis() - startTime));//时间戳
                if (rotatedFrame != null) {
                    recorder.record(rotatedFrame);
                }
                Thread.sleep(40);
            }
            return true;
        } catch (InterruptedException e) {
            LOGGER.error("推流线程被中断" + e.getMessage());
            stopAddRelease();

            return false;
        } catch (FrameRecorder.Exception e) {
            LOGGER.error("推流线程被中断" + e.getMessage());
            stopAddRelease();

            return false;
        } catch (FrameGrabber.Exception e) {
            LOGGER.error("推流线程被中断" + e.getMessage());
            stopAddRelease();
            return false;
        }
    }

    public boolean stopAddRelease() {
        try {
            recorder.stop();
            recorder.release();
            grabber.stop();
            isOpened = false;
        } catch (FrameRecorder.Exception e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        } catch (FrameGrabber.Exception e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        }
        LOGGER.info(lineName + "释放资源成功");
        return true;
    }

}
