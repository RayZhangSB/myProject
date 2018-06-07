package testRedis;

import com.zhang.ssm.video_stream.VideoStreamConverter;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.*;

/**
 * @ClassName Redis
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/6 9:22
 * @Version 1.0
 **/
public class Redis {
    @Test
    public void re() {
        //Connecting to Redis server on localhost

        String host  = "localhost";
        int port = 6379;
        Jedis jedis = null;
        try {
            jedis = new Jedis(host,port);
            jedis.select(1);
            jedis.set("name","kun");
            String name = jedis.get("name");
            System.out.println("name = " + name);
            jedis.flushDB();
            String name2 = jedis.get("name");
            System.out.println("name2 = " + name2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                try {
                    jedis.close();
                }catch (Exception e){
                    System.out.println("redis连接关闭失败");
                    e.printStackTrace();
                }
            }
        }
        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorialname"));





    }


    @Test
    public void redis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        ShardedJedisPool shardedJedisPool = applicationContext.getBean(ShardedJedisPool.class);
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        shardedJedis.set("test", "343900");
        System.out.println(shardedJedis.get("test"));

    }

    @Test
    public void converter() throws FrameRecorder.Exception, FrameGrabber.Exception {
        String src = "E:/HKfiles/web/RecordFiles/2018-04-15/0415-fire.mp4";
        String dest = "E:/13.mp4" ;
        FrameRecorder recorder = FFmpegFrameRecorder.createDefault(dest,1920,1080);
        FrameGrabber  grabber = FFmpegFrameGrabber.createDefault(new File(src));
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
        recorder.setFrameRate(25);
        recorder.setFormat("mp4");
        VideoStreamConverter v = new VideoStreamConverter(grabber,recorder,new OpenCVFrameConverter.ToIplImage(),"线路4");
        v.startGrabber();
        v.startRecorder();
        v.startPushStream();
    }

    @Test
    public void redisFrameSave() throws FrameGrabber.Exception {
        //Frame 没法序列化
        String host  = "localhost";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        String src = "E:\\HKfiles\\web\\RecordFiles\\2018-04-15/0415-fire.mp4";
        FrameGrabber  grabber = FFmpegFrameGrabber.createDefault(new File(src));
        OpenCVFrameConverter.ToIplImage a = new OpenCVFrameConverter.ToIplImage();
        grabber.start();
        Frame grabFrame = grabber.grab();
        opencv_core.IplImage grabbedImage = a.convert(grabFrame);
        ImgR imgR = new ImgR("lll",grabbedImage,System.currentTimeMillis(),0);
        jedis.set("ppp".getBytes(),serialize(grabbedImage));
        byte[] byt=jedis.get("ppp".getBytes());
        Object obj=unserizlize(byt);
        if(obj instanceof opencv_core.IplImage){
            System.out.println(obj);
        }


    }


    class ImgR implements Serializable{
        private String lineName;
        private opencv_core.IplImage grabbedImage = null;
        private long timestamp;
        private int abMark = 0;

        public ImgR(String lineName, opencv_core.IplImage grabbedImage, long timestamp, int abMark) {
            this.lineName = lineName;
            this.grabbedImage = grabbedImage;
            this.timestamp = timestamp;
            this.abMark = abMark;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public opencv_core.IplImage getGrabbedImage() {
            return grabbedImage;
        }

        public void setGrabbedImage(opencv_core.IplImage grabbedImage) {
            this.grabbedImage = grabbedImage;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getAbMark() {
            return abMark;
        }

        public void setAbMark(int abMark) {
            this.abMark = abMark;
        }
    }

    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }


        return null;
    }


    public static void recordCamera(String outputFile, double frameRate)
            throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
        Loader.load(opencv_objdetect.class);
        FrameGrabber grabber = FrameGrabber.createDefault(0);//本机摄像头默认0，这里使用javacv的抓取器，至于使用的是ffmpeg还是opencv，请自行查看源码
        grabber.start();//开启抓取器

        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();//转换器
        opencv_core.IplImage grabbedImage = converter.convert(grabber.grab());//抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
        int width = grabbedImage.width();
        int height = grabbedImage.height();

        FrameRecorder recorder = FrameRecorder.createDefault(outputFile, width, height);
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264，编码
        recorder.setFormat("flv");//封装格式，如果是推送到rtmp就必须是flv封装格式
        recorder.setFrameRate(frameRate);

        recorder.start();//开启录制器
        long startTime=0;
        long videoTS=0;

        Frame rotatedFrame=converter.convert(grabbedImage);//不知道为什么这里不做转换就不能推到rtmp
        while ( (grabbedImage = converter.convert(grabber.grab())) != null) {
            rotatedFrame = converter.convert(grabbedImage);

            if (startTime == 0) {
                startTime = System.currentTimeMillis();
            }
            videoTS = 1000 * (System.currentTimeMillis() - startTime);
            recorder.setTimestamp(videoTS);
            recorder.record(rotatedFrame);
            Thread.sleep(40);
        }
        recorder.stop();
        recorder.release();
        grabber.stop();

    }

    public static void main(String[] args) throws Exception {
        recordCamera("E:\\output.mp4",25);
    }


}
