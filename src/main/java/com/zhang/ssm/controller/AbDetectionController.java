package com.zhang.ssm.controller;

import com.zhang.ssm.console_pojo.UserConfig;
import com.zhang.ssm.service.AbDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AbDetectionController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/3 14:48
 * @Version 1.0
 **/
@Controller
@RequestMapping("/detect")
public class AbDetectionController {

    @Autowired
    private AbDetectionService abDetectionService;

    @RequestMapping("/setConfig")
    @ResponseBody
    public String setConfig(@RequestBody UserConfig config) {
        return abDetectionService.setConfig(config);
    }


}
