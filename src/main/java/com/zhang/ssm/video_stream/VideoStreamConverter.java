package com.zhang.ssm.video_stream;

import com.zhang.ssm.utils.DateUtil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;

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

    private boolean snapshot = false;
    //指示是否正在取流
    private boolean isOpened = false;

    private  boolean  stop = false;

    private String snapshot_save_path_prefix = "";

    private String snapshot_save_path;

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

    public boolean startGrabber() {
        try {
            grabber.start();

        } catch (FrameGrabber.Exception e) {
            LOGGER.error("抓取器启动失败，正在重新启动...");
            if (grabber != null) {
                try {
                    LOGGER.info("正在尝试关闭抓取器...");
                    grabber.stop();
                    LOGGER.info("正在尝试重新开启抓取器...");
                    grabber.start();
                    return true;
                } catch (Exception e1) {
                    LOGGER.error("抓取器启动失败..." + e1.getMessage());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean startRecorder() {
        try {
            recorder.start();
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
            try {
                LOGGER.error("录制器启动失败，正在重新启动...");
                if (recorder != null) {
                    LOGGER.info("正在尝试关闭录制器...");
                    recorder.stop();
                    LOGGER.info("正在尝试重新开启录制器...");
                    recorder.start();
                    return true;
                }
            } catch (Exception e1) {
                LOGGER.error("录制器启动失败--" + e1.getMessage());
                return false;
            }
        }
        return true;
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

    public String startSnapshot() {
        this.snapshot = true;
        return this.snapshot_save_path;
    }

    private void snapshotFrame(opencv_core.IplImage frame, Date date) {
        String name = DateUtil.genTime(date, "yyyy-MM-dd-HH-mm-SS");
        String path = snapshot_save_path_prefix + File.separator + name + ".jpg";
        opencv_imgcodecs.cvSaveImage(path, frame);
        this.snapshot_save_path = path;
        LOGGER.info("snapshot success");
    }

    public void getSourceInfo() {
        this.grabber.getFrameRate();
        this.grabber.getFormat();
        this.grabber.getVideoCodec();
        this.grabber.getSampleFormat();
        this.grabber.getBitsPerPixel();
        this.grabber.getImageWidth();
        this.grabber.getImageHeight();
        this.grabber.getMaxDelay();
    }

    public boolean startPushStream() {
        Loader.load(opencv_objdetect.class);
        long startTime = 0;
        Frame grabFrame = null;
        opencv_core.IplImage grabbedImage = null;
        try {
            while (!stop && (grabFrame = grabber.grab()) != null) {
                if (!isOpened) {
                    isOpened = true;
                }
                grabbedImage = converter.convert(grabFrame);
                Frame rotatedFrame = converter.convert(grabbedImage);
                if (startTime == 0) {
                    startTime = System.currentTimeMillis();
                }
                recorder.setTimestamp(1000 * (System.currentTimeMillis() - startTime));//时间戳
                if (rotatedFrame != null) {
                    recorder.record(rotatedFrame);
                    if (snapshot) {
                        snapshotFrame(grabbedImage, new Date());
                        snapshot = false;
                    }
                }
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {
            LOGGER.error("推流线程被中断" + e.getMessage());
            stopAndRelease();
            return false;
        } catch (FrameRecorder.Exception e) {
            LOGGER.error("推流线程被中断" + e.getMessage());
            stopAndRelease();
            return false;
        } catch (FrameGrabber.Exception e) {
            LOGGER.error("推流线程被中断" + e.getMessage());
            stopAndRelease();
            return false;
        }
        return true;
    }

    public boolean stopAndRelease() {
        if (!isOpened) {
            return true;
        }
        try {
            stop = true;
            Thread.sleep(40);
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
        } catch (InterruptedException e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        } finally {
            recorder = null;
            grabber = null;
            converter = null;
            isOpened = false;
            stop = false;
        }
        LOGGER.info(lineName + "释放资源成功");
        return true;
    }

}
