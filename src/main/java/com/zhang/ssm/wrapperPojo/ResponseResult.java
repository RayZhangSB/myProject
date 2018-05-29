package com.zhang.ssm.wrapperPojo;

/**
 * 自定义响应结构
 */
public class ResponseResult {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResponseResult build(Integer code, String msg, Object data) {

        return new ResponseResult(code, msg, data);
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(data);
    }

    public static ResponseResult ok() {
        return new ResponseResult(null);
    }

    public static ResponseResult build(Integer code, String msg) {
        return new ResponseResult(code, msg, null);
    }

    public ResponseResult(Integer code, String msg) {
        this(code, msg, null);
    }

    public ResponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Object data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
