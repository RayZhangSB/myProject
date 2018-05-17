package com.zhang.ssm.controller;

import com.zhang.ssm.model.User;
import com.zhang.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;


    @RequestMapping("/r")
    public String showUser2(HttpServletRequest request, Model model){
        log.info("查询一个用户信息rrrrrrr");
        User user = userService.getUserById(1L);
        //model.addAttribute("userList",userList);
        return "redirect:showUser";  //地址不变
    }
}
