package com.zhang.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    @RequestMapping("/user/add")
    public String addUser() {
        return "index";
    }

}
