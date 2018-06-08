package testJavacv;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.junit.Test;

import javax.swing.*;
import java.io.*;

/**
 * @ClassName aearewq
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/8 15:15
 * @Version 1.0
 **/
public class test1 {

    @Test
    public void lll() throws FrameGrabber.Exception, InterruptedException {

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);

        while(true)
        {
            if(!canvas.isDisplayable())
            {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(2);//退出
            }
            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像

            Thread.sleep(50);//50毫秒刷新一次图像
        }
    }


    @Test
    public void savepic() throws IOException {
        long time1 = System.currentTimeMillis();
        File file1 = new File("C:\\Users\\Raymond Zhang\\Pictures/IU1.jpg");
        InputStream in = new BufferedInputStream(new FileInputStream(file1));
        byte[] r= new byte[1024];
        int len = 0;
        while((len = in.read(r))!= -1){

        }
        in.close();
        System.out.println(System.currentTimeMillis()-time1);
    }



}
