package com.zhang.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhang.ssm.WrapperPOJO.ResponseResult;
import com.zhang.ssm.mapper.UserMapper;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public String registerUser(User user) {
        int res = userMapper.insert(user);
        int code = 1;
        String msg;
        if (res <= 0) {
            msg = "注册失败";
        } else {
            code = 0;
            msg = String.valueOf(user.getUserId());
        }
        return JSON.toJSONString(ResponseResult.build(code, msg));
    }
}


