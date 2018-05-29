package com.zhang.ssm.service.impl;

import com.zhang.ssm.mapper.TokenMapper;
import com.zhang.ssm.mapper.UserMapper;
import com.zhang.ssm.pojo.Token;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.UserService;
import com.zhang.ssm.utils.DateUtil;
import com.zhang.ssm.utils.IDUtil;
import com.zhang.ssm.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public String registerUser(User user) {
        User u = userMapper.selectByName(user.getUserName());
        int code = 0;
        String msg = "";
        if (u != null) {
            code = 1;
            msg = "用户已经注册过了";
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
        msg = res > 0 ? "注册成功" : "注册失败";
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
            msg = "用户不存在";
        } else {
            if (IDUtil.encodedString(userPassword + res.getUserSalt()).equals(res.getUserPassword())) {

                code = 0;
                msg = "登录成功";
                String ticket = addLoginTicket(res.getUserId());
                map.put("ticket", ticket);
            } else {
                msg = "用户名或密码错误";
            }
        }
        map.put("resultJson", JsonUtil.getJSONString(code, msg));
        return map;

    }

    private String addLoginTicket(int userId) {
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

}


