package com.zhang.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/17 11:40
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @RequestMapping("/toIndex")
    public String forwordToMain() {
        return "homePage";
    }

    @RequestMapping("/toRegister")
    public String forwordToRegister() {
        return "register";
    }


}
