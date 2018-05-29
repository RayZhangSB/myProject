package com.zhang.ssm.controller;

import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.RealMonitorDataService;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.wrapperPojo.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName MonitorController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/28 16:28
 * @Version 1.0
 **/
@Controller
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    private UserHolder userHolder;
    @Autowired
    private RealMonitorDataService realMonitorDataService;


    @RequestMapping(value = "/getScope", method = RequestMethod.POST)
    @ResponseBody
    public String getScope() {
        User user = userHolder.getUser();
        if (user == null) {
            return JsonUtil.getJSONString(6, "用户身份过期，请重新登录!");
        }
        return realMonitorDataService.getScope(user);

    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ResponseBody
    public String getRealMonitorData() {
        return realMonitorDataService.getRealMonitorData();
    }


}
