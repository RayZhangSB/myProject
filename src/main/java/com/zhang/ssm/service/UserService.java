package com.zhang.ssm.service;

import com.zhang.ssm.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {

    String registerUser(User user);

    User getUserById(Integer userId);

    User getUserByName(String userName);

    String userLogin(String userName, String userPassword, int rememberMe, HttpServletResponse response);

    String rememberLogin(String ticket);

    String getUserSimpleInfo();

    String getUserInfo();


    String updatePwd(String opass, String npass);


    String updateUserInfo(User user);

    String uploadUserHead(MultipartFile file, HttpServletRequest request);
}
