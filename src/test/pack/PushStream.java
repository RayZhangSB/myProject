package pack;

import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.video_stream.VideoStreamConverter;
import com.zhang.ssm.video_stream.VideoStreamFactory;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PushStream
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/11 14:08
 * @Version 1.0
 **/
public class PushStream {


    public static void main(String[] a) throws FrameGrabber.Exception {
        String src = "rtsp://admin:ma12345678@192.168.1.88/h264/ch0/main/av_stream";
        String dest= "rtmp://127.0.0.1/live/stream";
        VideoStreamFactory factory = VideoStreamFactory.getInstance();
        FrameGrabber grabber= FFmpegFrameGrabber.createDefault(src);
       FrameRecorder recorder=factory.createRecorder(dest,1920,1080, avcodec.AV_CODEC_ID_H264,"flv",25,25);
        VideoStreamConverter v =factory.createVideoStreamConverter("xxx",grabber,recorder,factory.createImgConverter());
//        VideoStreamConverter v = new VideoStreamConverter(grabber, recorder, factory.createImgConverter(), "fsdf");
        v.startGrabber();
        v.startRecorder();
//        factory.startPreparing();
//
//        factory.startAllPush();
        v.startPushStream();


    }


    public static void recordPush(String src,String outputFile,int v_rs) throws Exception{
        Loader.load(opencv_objdetect.class);
        long startTime=0;
        FrameGrabber grabber =FFmpegFrameGrabber.createDefault(src);
        try {
            grabber.start();
        } catch (Exception e) {
            try {
                grabber.restart();
            } catch (Exception e1) {
                throw e;
            }
        }

        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        Frame grabframe =grabber.grab();
        opencv_core.IplImage grabbedImage =null;
        if(grabframe!=null){
            System.out.println("取到第一帧");
            grabbedImage = converter.convert(grabframe);
        }else{
            System.out.println("没有取到第一帧");
        }
        //如果想要保存图片,可以使用 opencv_imgcodecs.cvSaveImage("hello.jpg", grabbedImage);来保存图片
        FrameRecorder recorder;
        try {
            recorder = FrameRecorder.createDefault(outputFile, 1280, 720);
        } catch (FrameRecorder.Exception e) {
            throw e;
        }
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264
        recorder.setFormat("flv");
        recorder.setFrameRate(v_rs);
        recorder.setGopSize(v_rs);
        System.out.println("准备开始推流...");
        try {
            recorder.start();
        } catch (FrameRecorder.Exception e) {
            try {
                System.out.println("录制器启动失败，正在重新启动...");
                if(recorder!=null)
                {
                    System.out.println("尝试关闭录制器");
                    recorder.stop();
                    System.out.println("尝试重新开启录制器");
                    recorder.start();
                }

            } catch (FrameRecorder.Exception e1) {
                throw e;
            }
        }
        System.out.println("开始推流");

        while ( (grabframe=grabber.grab()) != null) {
            System.out.println("推流...");
            grabbedImage = converter.convert(grabframe);
            Frame rotatedFrame = converter.convert(grabbedImage);

            if (startTime == 0) {
                startTime = System.currentTimeMillis();
            }
            recorder.setTimestamp(1000 * (System.currentTimeMillis() - startTime));//时间戳
            if(rotatedFrame!=null){
                recorder.record(rotatedFrame);
            }

            Thread.sleep(40);
        }
        recorder.stop();
        recorder.release();
        grabber.stop();
        System.exit(2);
    }


    @Test
    public void jjj(){
        int i = 0;
        List<AbnormalInfo> ff = new ArrayList<AbnormalInfo>();
        while(i<4) {
            AbnormalInfo dd = new AbnormalInfo();
            Date d = new Date();
            dd.setCreateTime(d);
            ff.add(dd);
        }

    }


}
