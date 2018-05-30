package com.zhang.ssm.wrapperPojo;

import org.springframework.stereotype.Component;

/**
 * @ClassName AuthCodeHolder
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/30 9:35
 * @Version 1.0
 **/
@Component
public class AuthCodeHolder {
    private static ThreadLocal<Integer> authCode = new ThreadLocal<Integer>();


    public Integer getAuthCode() {
        return authCode.get();
    }

    public void setAuthCode(Integer code) {
        authCode.set(code);
    }

    public void clear() {
        authCode.remove();

    }


}
