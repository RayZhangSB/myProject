package com.zhang.ssm.Controller;

import com.zhang.ssm.Service.UserService;
import com.zhang.ssm.Utils.JsonUtils;
import com.zhang.ssm.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
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
    public String userLogin(String userName, String userPassword, @RequestParam(value = "rememberMe", defaultValue = "0") int rememberMe, HttpServletResponse response) {
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
        return JsonUtils.getJSONString(1, "map数据异常");
    }

}
