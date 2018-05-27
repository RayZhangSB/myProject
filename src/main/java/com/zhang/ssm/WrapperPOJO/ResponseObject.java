package com.zhang.ssm.WrapperPOJO;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResponseObject
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/27 9:25
 * @Version 1.0
 **/
public class ResponseObject {
    private Map<String, Object> map = new HashMap<String, Object>();

    public void set(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

}
