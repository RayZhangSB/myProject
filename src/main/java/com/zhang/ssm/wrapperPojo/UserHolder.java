package com.zhang.ssm.wrapperPojo;

import com.zhang.ssm.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserHolder
 * @Description: 多个用户访问时保存当前用户信息
 * @Author Raymond Zhang
 * @Date 2018/5/27 15:00
 * @Version 1.0
 **/
@Component
public class UserHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();

    }

}
