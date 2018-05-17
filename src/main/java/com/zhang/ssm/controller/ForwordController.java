package com.zhang.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ForwordController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/17 11:06
 * @Version 1.0
 **/
@Controller
public class ForwordController {

    @RequestMapping("/")
    public String forwordToMain(){
        return "login";
    }




}
