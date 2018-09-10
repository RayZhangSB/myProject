package com.zhang.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ForwordController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/17 11:06
 * @Version 1.0
 **/
@Controller
public class ForwardController {

    @RequestMapping("/")
    public String forwardToLogin() {
        return "main";
    }

    @RequestMapping("/{page}")
    public String pageForward(@PathVariable String page) {

        return page;
    }


}
