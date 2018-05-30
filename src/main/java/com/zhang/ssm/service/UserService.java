package com.zhang.ssm.service;

import com.zhang.ssm.pojo.User;

import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {

    String registerUser(User user);

    User getUserById(Integer userId);

    User getUserByName(String userName);

    Map<String, Object> userLogin(String userNameOrId, String userPassword);

    String rememberLogin(String ticket);
}
