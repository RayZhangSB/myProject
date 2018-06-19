package testPushStream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName testJsonUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/28 21:33
 * @Version 1.0
 **/
public class testJsonUtil {

    @Test
    public void testObjToJson() {
        Map<String, Object> data = new HashMap<String, Object>();
        List<AbnormalInfo>  dat = new ArrayList<AbnormalInfo>();
        ResponseResult responseResult = ResponseResult.ok();
        AbnormalInfo ab_info  = new AbnormalInfo();
        ab_info.setCreateTime(new Date());
        ab_info.setAbnormalImgUrl("rthfhhtugyjyj.jpg");
        ab_info.setLineName("asdsad");
        ab_info.setAbnormalCode(0);
        ab_info.setProcessed(0);
        AbnormalInfo ab_info1  = new AbnormalInfo();
        ab_info1.setCreateTime(new Date());
        ab_info1.setAbnormalImgUrl("rthfhhtugyjyj.jpg");
        ab_info1.setLineName("asdsad");
        ab_info1.setAbnormalCode(0);
        ab_info1.setProcessed(0);
        dat.add(ab_info);

        dat.add(ab_info1);
        responseResult.setData(dat);
        String res =  JSON.toJSONStringWithDateFormat(dat, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        System.out.println(res);

    }


}
