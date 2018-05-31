package com.zhang.ssm.service.impl;

import com.zhang.ssm.holder.UserHolder;
import com.zhang.ssm.mapper.TokenMapper;
import com.zhang.ssm.mapper.UserMapper;
import com.zhang.ssm.pojo.Token;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.UserService;
import com.zhang.ssm.utils.*;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private UserHolder userHolder;


    public String registerUser(final User user) {
        User u = userMapper.selectByName(user.getUserName());
        ResponseResult responseResult = ResponseResult.ok();
        if (u != null) {
            responseResult.setCode(1);
            responseResult.setMsg("The user is already registered");
        } else {
            String salt = IDUtil.genSalt();
            user.setUserSalt(salt);
            user.setUserPassword(IDUtil.encodedString(user.getUserPassword() + salt));
            Date date = DateUtil.genFormatDate(new Date());
            user.setUserCreateddate(date);
            if (user.getUserHeadurl() == null) {
                user.setUserHeadurl("/images/y.jpg");
            }
            try {
                userMapper.insert(user);
                responseResult.setMsg("register success");
            } catch (Exception e) {
                String msg = "register failed";
                responseResult.setCode(1);
                responseResult.setMsg(msg);
                LOGGER.error(e.getMessage() + "--->" + msg);
            }

        }
        return JsonUtil.objectToJson(responseResult);

    }

    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public User getUserByName(String userName) {
        return userMapper.selectByName(userName);
    }


    public Map<String, Object> userLogin(String userName, String userPassword) {
        User res = userMapper.selectByName(userName);
        int code = 1;
        String msg;
        Map<String, Object> map = new HashMap<String, Object>();
        if (res == null) {
            msg = "user do not exist";
        } else {
            if (IDUtil.encodedString(userPassword + res.getUserSalt()).equals(res.getUserPassword())) {

                code = 0;
                msg = "login success";
                String ticket = addLoginTicket(res.getUserId());
                map.put("ticket", ticket);
            } else {
                msg = "wrong user name or password";
            }
        }
        map.put("resultJson", JsonUtil.getJSONString(code, msg));
        return map;

    }


    public String addLoginTicket(int userId) {
        Token ticket = new Token();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600 * 24);
        ticket.setTokenExpired(date);
        ticket.setTokenStatus(0);
        ticket.setTokenTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenMapper.insert(ticket);
        return ticket.getTokenTicket();
    }

    public String rememberLogin(String ticket) {
        ResponseResult responseResult = ResponseResult.ok();
        if (ticket != null) {
            Token token = tokenMapper.selectByTicket(ticket);
            if (token == null || token.getTokenExpired().before(new Date()) || token.getTokenStatus() != 0) {
                responseResult.setCode(1);
            }
        } else {
            responseResult.setCode(1);
        }

        return JsonUtil.objectToJson(responseResult);
    }


    public String initUserInfoShow() {
        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(1);
            responseResult.setMsg("failed to fetch user info ,please  try after login");
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userName", user.getUserName());
            map.put("headUrl", user.getUserHeadurl());
            responseResult.setData(map);
        }

        return JsonUtil.objectToJson(responseResult);
    }

    public String getUserInfo() {
        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(1);
            responseResult.setMsg("failed to fetch user info ,please  try after login");
        } else {
            responseResult.setData(user);
        }
        return JsonUtil.objectToJson(responseResult);
    }

    public String updatePwd(String opass, String npass) {

        ResponseResult responseResult = ResponseResult.ok();
        User user = userHolder.getUser();
        if (user == null) {
            responseResult.setCode(1);
            responseResult.setMsg("failed to fetch user info ,please  try after login");
        } else {
            if (IDUtil.encodedString(opass + user.getUserSalt()).equals(user.getUserPassword())) {
                //old password right
                User u = user;
                u.setUserPassword(IDUtil.encodedString(npass + user.getUserSalt()));
                userMapper.updateByPrimaryKeySelective(u);
                responseResult.setMsg("password update success,please login again");
            } else {
                responseResult.setCode(1);
                responseResult.setMsg("error password");
            }
        }
        return JsonUtil.objectToJson(responseResult);


    }


    public String updateUserInfo(final User user) {

        ResponseResult responseResult = ResponseResult.ok();
        try {
            userMapper.updateByPrimaryKeySelective(user);
            responseResult.setMsg("info update success");
        } catch (Exception e) {
            String msg = "info update failed";
            responseResult.setCode(1);
            responseResult.setMsg(msg);
            LOGGER.error(e.getMessage() + "--->" + msg);
        }

        return JsonUtil.objectToJson(responseResult);
    }

    public String uploadUserHead(final MultipartFile file, HttpServletRequest request) {
        File targetFile = null;
        ResponseResult responseResult = ResponseResult.ok();
        String msg;
        String fileName = file.getOriginalFilename();//获取文件名加后缀
        if (StringUtil.isNotEmpty(fileName)) {
            String suffix = FileUtil.getFileSuffix(fileName);
            fileName = IDUtil.genImageName();
            String newFileName = fileName + suffix;//新的文件名
            // 获得项目的路径
            ServletContext sc = request.getSession().getServletContext();
            // 上传位置
            String savePath = sc.getRealPath(File.separator + "WEB-INF" + FileUtil.HEAD_SAVE_DIR) + File.separator; // 设定文件保存的目录


            File saveDir = new File(savePath);
            String saveFullPath = savePath + File.separator + newFileName;
            targetFile = new File(saveFullPath);
            if (!saveDir.exists() && !saveDir.isDirectory()) {
                try {
                    saveDir.mkdirs();
                } catch (Exception e) {
                    responseResult.setCode(1);
                    msg = "failed to create photo save dir";
                    responseResult.setMsg(msg);
                    LOGGER.error(e.getMessage() + "--->" + msg);
                }
            } else {
                try {
                    file.transferTo(targetFile);
                    msg = FileUtil.HEAD_SAVE_DIR + newFileName;
                    responseResult.setMsg(msg);
                } catch (IOException e) {
                    msg = "occurred Exception while saving img file";
                    responseResult.setCode(1);
                    responseResult.setMsg(msg);
                    LOGGER.error(e.getMessage() + "--->" + msg);
                }
            }
        }
        return JsonUtil.objectToJson(responseResult);
    }


}


