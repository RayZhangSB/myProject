package com.zhang.ssm.service.impl;

import com.zhang.ssm.service.VideoStreamConverterService;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.*;

import javax.swing.*;

/**
 * @ClassName VideoStreamConverterServiceImpl
 * @Description: 转流器实现
 * @Author Raymond Zhang
 * @Date 2018/6/4 19:37
 * @Version 1.0
 **/
public class VideoStreamConverterServiceImpl implements VideoStreamConverterService {


    public  void convert(String inputFile, String outputFile, int v_fr) {
        Loader.load(opencv_objdetect.class);
        long startTime=0;
        FrameGrabber grabber = null;
        try {
            grabber = FFmpegFrameGrabber.createDefault(inputFile);
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
        try {

                grabber.start();

        } catch (Exception e) {
            try {
                grabber.restart();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        Frame grabframe = null;
        try {
            grabframe = grabber.grab();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
        opencv_core.IplImage grabbedImage =null;
        if(grabframe!=null){
            System.out.println("取到第一帧");
            grabbedImage = converter.convert(grabframe);
        }else{
            System.out.println("没有取到第一帧");
        }


        //如果想要保存图片,可以使用 opencv_imgcodecs.cvSaveImage("hello.jpg", grabbedImage);来保存图片
        FrameRecorder recorder = null;
        try {
            recorder = FrameRecorder.createDefault(outputFile, 1920, 1080);
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e2) {
            e2.printStackTrace();
        }
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264
        recorder.setFormat("flv");
        recorder.setFrameRate(v_fr);
        recorder.setGopSize(v_fr);
        System.out.println("准备开始推流...");
        try {
            recorder.start();
        } catch (org.bytedeco.javacv.FrameRecorder.Exception e) {
            try {
                System.out.println("录制器启动失败，正在重新启动...");
                if(recorder!=null)
                {
                    System.out.println("尝试关闭录制器");
                    recorder.stop();
                    System.out.println("尝试重新开启录制器");
                    recorder.start();
                }

            } catch (org.bytedeco.javacv.FrameRecorder.Exception e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("开始推流");
        CanvasFrame frame = new CanvasFrame("camera", CanvasFrame.getDefaultGamma() / grabber.getGamma());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        try {
            grabframe=grabber.grab();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
        while (frame.isVisible() && (grabframe != null)) {
            System.out.println("推流...");
            frame.showImage(grabframe);
            grabbedImage = converter.convert(grabframe);
            Frame rotatedFrame = converter.convert(grabbedImage);

            if (startTime == 0) {
                startTime = System.currentTimeMillis();
            }
            recorder.setTimestamp(1000 * (System.currentTimeMillis() - startTime));//时间戳
            if(rotatedFrame!=null){
                try {
                    recorder.record(rotatedFrame);
                } catch (FrameRecorder.Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame.dispose();
        try {
            recorder.stop();
        } catch (FrameRecorder.Exception e) {
            e.printStackTrace();
        }
        try {
            recorder.release();
        } catch (FrameRecorder.Exception e) {
            e.printStackTrace();
        }
        try {
            grabber.stop();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
        System.exit(2);
    }
}
