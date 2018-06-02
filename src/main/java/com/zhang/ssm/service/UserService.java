package com.zhang.ssm.service;

import com.zhang.ssm.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    String getUserSimpleInfo();

    String getUserInfo();


    String updatePwd(String opass, String npass);


    String updateUserInfo(User user);

    String uploadUserHead(MultipartFile file, HttpServletRequest request);
}
