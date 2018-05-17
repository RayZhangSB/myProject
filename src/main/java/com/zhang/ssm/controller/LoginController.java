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
@RequestMapping("/userAccess")
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
