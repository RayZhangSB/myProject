package com.zhang.ssm.service.impl;

import com.zhang.ssm.mapper.TokenMapper;
import com.zhang.ssm.mapper.UserMapper;
import com.zhang.ssm.pojo.Token;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.UserService;
import com.zhang.ssm.utils.DateUtil;
import com.zhang.ssm.utils.IDUtil;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import com.zhang.ssm.wrapperPojo.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private UserHolder userHolder;


    public String registerUser(User user) {
        User u = userMapper.selectByName(user.getUserName());
        int code = 0;
        String msg = "";
        if (u != null) {
            code = 1;
            msg = "The user is already registered";
            return JsonUtil.getJSONString(code, msg);
        }
        String salt = IDUtil.genSalt();
        user.setUserSalt(salt);
        user.setUserPassword(IDUtil.encodedString(user.getUserPassword() + salt));
        Date date = DateUtil.genFormatDate(new Date());
        user.setUserCreateddate(date);
        if (user.getUserHeadurl() == null) {
            user.setUserHeadurl("/images/y.jpg");
        }
        int res = userMapper.insert(user);

        code = res > 0 ? 0 : 1;
        msg = res > 0 ? "register success" : "register failed";
        return JsonUtil.getJSONString(code, msg);

    }

    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public User getUserByName(String userName) {
        return userMapper.selectByName(userName);
    }


    public Map<String, Object> userLogin(String userName, String userPassword) {
        User res = userMapper.selectByName(userName);
        int code = 1;
        String msg;
        Map<String, Object> map = new HashMap<String, Object>();
        if (res == null) {
            msg = "user do not exist";
        } else {
            if (IDUtil.encodedString(userPassword + res.getUserSalt()).equals(res.getUserPassword())) {

                code = 0;
                msg = "login success";
                String ticket = addLoginTicket(res.getUserId());
                map.put("ticket", ticket);
            } else {
                msg = "wrong user name or password";
            }
        }
        map.put("resultJson", JsonUtil.getJSONString(code, msg));
        return map;

    }


    public String addLoginTicket(int userId) {
        Token ticket = new Token();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600 * 24);
        ticket.setTokenExpired(date);
        ticket.setTokenStatus(0);
        ticket.setTokenTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenMapper.insert(ticket);
        return ticket.getTokenTicket();
    }

    public String rememberLogin(String ticket) {
        ResponseResult responseResult = ResponseResult.ok();
        if (ticket != null) {
            Token token = tokenMapper.selectByTicket(ticket);
            if (token == null || token.getTokenExpired().before(new Date()) || token.getTokenStatus() != 0) {
                responseResult.setCode(1);
            }
        } else {
            responseResult.setCode(1);
        }

        return JsonUtil.objectToJson(responseResult);
    }


    public String initUserInfoShow() {
        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(1);
            responseResult.setMsg("failed to fetch user info ,please  try after login");
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userName", user.getUserName());
            map.put("headUrl", user.getUserHeadurl());
            responseResult.setData(map);
        }

        return JsonUtil.objectToJson(responseResult);
    }

    public String getUserInfo() {
        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(1);
            responseResult.setMsg("failed to fetch user info ,please  try after login");
        } else {
            responseResult.setData(user);
        }
        return JsonUtil.objectToJson(responseResult);
    }

    public String updatePwd(String opass, String npass) {

        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(1);
            responseResult.setMsg("failed to fetch user info ,please  try after login");
        } else {
            if (IDUtil.encodedString(opass + user.getUserSalt()).equals(user.getUserPassword())) {
                //old password right
                User u = user;
                u.setUserPassword(IDUtil.encodedString(npass + user.getUserSalt()));
                userMapper.updateByPrimaryKeySelective(u);
                responseResult.setMsg("password update success,please login again");
            } else {
                responseResult.setCode(1);
                responseResult.setMsg("error password");
            }
        }
        return JsonUtil.objectToJson(responseResult);


    }


    public String updateUserInfo(User user) {
        return null;
    }

    public String uploadUserHead(MultipartFile file, HttpServletRequest request) {
        return null;
    }


}


