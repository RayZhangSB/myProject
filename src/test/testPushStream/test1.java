package testPushStream;

import com.zhang.ssm.mapper.AbnormalInfoMapper;
import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.utils.FileUtil;
import org.bytedeco.javacv.FrameGrabber;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Date;

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

        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        AbnormalInfoMapper  ab = (AbnormalInfoMapper) applicationContext.getBean("abnormalInfoMapper",AbnormalInfoMapper.class);
        AbnormalInfo ab_info  = new AbnormalInfo();
        ab_info.setCreateTime(new Date());
        ab_info.setAbnormalImgUrl("rthfhhtugyjyj.jpg");
        ab_info.setLineName("asdsad");
        ab_info.setAbnormalCode(0);
        ab_info.setProcessed(0);
        ab.insert(ab_info);

    }


    @Test
    public void savepic() throws IOException {
        long time1 = System.currentTimeMillis();
        String src1="C:\\Users\\Raymond Zhang\\Pictures/IU1.jpg";
        String dest1 = "C:\\Users\\Raymond Zhang\\Pictures/IU11.jpg";
        String src2 = "C:\\Users\\Raymond Zhang\\Pictures/IU2.jpg";
        String dest2 = "C:\\Users\\Raymond Zhang\\Pictures/IU22.jpg";
        String src3 = "C:\\Users\\Raymond Zhang\\Pictures/IU3.jpg";
        String dest3 = "C:\\Users\\Raymond Zhang\\Pictures/IU33.jpg";
        FileUtil.uploadImageFromLocal(src1,dest1);
        FileUtil.uploadImageFromLocal(src2,dest2);
        FileUtil.uploadImageFromLocal(src3,dest3);

//        FileUtil.up(src1,dest1);
//        FileUtil.up(src2,dest2);
//        FileUtil.up(src3,dest3);
        System.out.println(System.currentTimeMillis()-time1);
    }



}
