package com.zhang.ssm.WrapperPOJO;

import java.util.Map;

/**
 * @ClassName ResponseResult
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/18 17:13
 * @Version 1.0
 **/
public class ResponseResult {
    private Integer code;

    private String message;

    private Map<String, Object> result;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResult() {
        return this.result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    private static ResponseResult responseResult;

    /**
     * 返回结果
     *
     * @param code
     * @param message
     * @param map
     * @return
     */
    public static ResponseResult result(int code, String message, Map<String, Object> map) {
        responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setResult(map);
        return responseResult;
    }

    public static ResponseResult result(int code, String message) {
        responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        return responseResult;
    }

    public ResponseResult() {
    }

}
