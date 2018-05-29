package testJson;

import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import com.zhang.ssm.wrapperPojo.SimulationData;
import org.junit.Test;

import java.util.HashMap;

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
        HashMap<String, Object> map = new HashMap<String, Object>();

        ResponseResult responseResult = ResponseResult.ok(map);

        responseResult.setData(SimulationData.genRandomData());

        String res = JsonUtil.objectToJson(responseResult);
        System.out.println(res);


    }


}
