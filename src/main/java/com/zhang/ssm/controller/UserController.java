package com.zhang.ssm.controller;

import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.UserService;
import com.zhang.ssm.utils.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Zhang on 2018/5/26.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    /*
    用户登录验证
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(String userName, String userPassword, int rememberMe, HttpServletResponse response) {
        Map<String, Object> map = null;
        try {
            map = userService.userLogin(userName, userPassword);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (rememberMe > 0) {
                    cookie.setMaxAge(3600 * 24 * 5);
                }
                response.addCookie(cookie);
            }

        } catch (Exception e) {
            LOGGER.error("登录异常" + e.getMessage());

        }
        if (map != null && map.containsKey("resultJson")) {
            return (String) map.get("resultJson");
        }
        return JsonUtil.getJSONString(1, "map数据异常");
    }


    @RequestMapping(value = "/rememberLogin", method = RequestMethod.POST)
    @ResponseBody
    public String rememberLogin(String ticket) {
        return userService.rememberLogin(ticket);
    }

    @RequestMapping(value = "/initShowInfo", method = RequestMethod.GET)
    @ResponseBody
    public String forUserSimpleInfo() {
        return userService.initUserInfoShow();
    }


    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public String forUserInfo() {
        return userService.getUserInfo();
    }


    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public String updatePwd(String opass, String npass) {
        return userService.updatePwd(opass, npass);
    }


    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public String updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }


    @ResponseBody
    @RequestMapping("/uploadUserHead")
    public String uploadUserHead(@RequestParam(value = "head") MultipartFile file,
                                 HttpServletRequest request) {

        return userService.uploadUserHead(file, request);
    }






}
