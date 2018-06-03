package com.zhang.ssm.service.impl;

import com.zhang.ssm.console_pojo.UserConfig;
import com.zhang.ssm.holder.UserHolder;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.AbDetectionService;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AbDetectionServiceImpl
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/3 18:24
 * @Version 1.0
 **/
@Service
public class AbDetectionServiceImpl implements AbDetectionService {

    @Autowired
    private UserHolder userHolder;

    public String setConfig(final UserConfig config) {
        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(2);
            responseResult.setMsg("Bad user login status");
        } else {
            responseResult.setMsg("setup success");
        }
        return null;
    }
}
