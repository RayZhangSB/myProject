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
    private boolean has_Opened = false;

    private boolean stop_running = false;

    private String snapshot_save_path_prefix = "";

    private String snapshot_save_path;

    private boolean recorder_started = false;

    public VideoStreamConverter(FrameGrabber grabber, FrameRecorder recorder, OpenCVFrameConverter.ToIplImage converter, String lineName) {
        this.recorder = recorder;
        this.grabber = grabber;
        this.converter = converter;
        this.lineName = lineName;
    }

    public FrameRecorder getRecorder() {
        return recorder;
    }

    public void setRecorder(FrameRecorder recorder) {
        this.recorder = recorder;
    }

    public FrameGrabber getGrabber() {
        return grabber;
    }

    public void setGrabber(FrameGrabber grabber) {
        this.grabber = grabber;
    }

    public OpenCVFrameConverter.ToIplImage getConverter() {
        return converter;
    }

    public void setConverter(OpenCVFrameConverter.ToIplImage converter) {
        this.converter = converter;
    }

    public String getLineName() {
        return lineName;
    }

    public boolean isRunning() {
        return has_Opened;
    }

    public boolean startGrabber() {
        try {
            if (grabber != null) {
                grabber.stop();
                grabber.start();
                int count_tryStart = 0;
                while (grabber.grab() == null) {
                    count_tryStart++;
                    grabber.restart();
                    if (count_tryStart >= 50) {
                        return false;
                    }
                }
            } else {
                LOGGER.error("请设置正确的抓取器...");
                return false;
            }
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
            if (recorder_started) {
                return true;
            }
            if (recorder != null) {
                recorder.stop();
                recorder.start();
                recorder_started = true;
            } else {
                LOGGER.error("请设置正确的录制器...");
                return false;
            }
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
            try {
                LOGGER.error("录制器启动失败，正在重新启动...");
                if (recorder != null) {
                    LOGGER.info("正在尝试关闭录制器...");
                    recorder.stop();
                    LOGGER.info("正在尝试重新开启录制器...");
                    recorder.start();
                    recorder_started = true;
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
            while (!stop_running && (grabFrame = grabber.grab()) != null) {
                if (!has_Opened) {
                    has_Opened = true;
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
                Thread.sleep(25);
            }
            has_Opened = false;
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
        if (!stop()) {
            return true;
        }
        try {
            if (grabber != null) {
                grabber.release();
            }
            if (recorder != null) {
                recorder.release();
            }
        } catch (FrameRecorder.Exception e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        } catch (FrameGrabber.Exception e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        } finally {
            recorder = null;
            grabber = null;
            converter = null;
            recorder_started = false;
        }
        LOGGER.info(lineName + "释放资源成功");
        return true;
    }


    public boolean stop() {
        if (!isRunning()) {
            return true;
        }
        try {
            stop_running = true;
            Thread.sleep(40);
            grabber.stop();
//            recorder.stop();
        }
//        catch (FrameRecorder.Exception e) {
//            LOGGER.error("释放资源失败" + e.getMessage());
//            return false;
//        }
        catch (FrameGrabber.Exception e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        } catch (InterruptedException e) {
            LOGGER.error("释放资源失败" + e.getMessage());
            return false;
        } finally {
            has_Opened = false;
            stop_running = false;
        }
        LOGGER.info(lineName + "释放资源成功");
        return true;
    }


}
