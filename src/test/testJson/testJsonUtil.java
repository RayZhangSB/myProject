package testJson;

import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import com.zhang.ssm.wrapperPojo.SimulationData;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

        ResponseResult responseResult = ResponseResult.ok();
        String contentScope = "monitor1-monitor2";
        String[] a = {"monitor1", "monitor2"};
        String[] names = contentScope.split("-");
        for (String name : names) {
            data.put(name, SimulationData.genRandomData());
        }
        responseResult.setData(a);

        String res = JsonUtil.objectToJson(responseResult);
        System.out.println(res);


    }


}
