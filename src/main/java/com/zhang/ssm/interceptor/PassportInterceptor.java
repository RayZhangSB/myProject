package com.zhang.ssm.interceptor;

import com.zhang.ssm.holder.AuthCodeHolder;
import com.zhang.ssm.holder.MonitorsScopeHolder;
import com.zhang.ssm.holder.UserHolder;
import com.zhang.ssm.mapper.AuthGroupMapper;
import com.zhang.ssm.mapper.AuthOpreatorMapper;
import com.zhang.ssm.mapper.TokenMapper;
import com.zhang.ssm.mapper.UserMapper;
import com.zhang.ssm.pojo.AuthGroup;
import com.zhang.ssm.pojo.AuthOpreator;
import com.zhang.ssm.pojo.Token;
import com.zhang.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by nowcoder on 2018/5/27.
 */
@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserHolder userHolder;
    @Autowired
    private MonitorsScopeHolder monitors;
    @Autowired
    private AuthCodeHolder authCodeHolder;

    @Autowired
    private AuthGroupMapper authGroupMapper;
    @Autowired
    private AuthOpreatorMapper authOpreatorMapper;
    /*
    对所有访问拦截查询是否已登录，是则将用户信息写入到线程私有变量
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ticket = null;
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("ticket")) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }
        if (ticket != null) {
            Token token = tokenMapper.selectByTicket(ticket);
            if (token == null || token.getTokenExpired().before(new Date()) || token.getTokenStatus() != 0) {
                return true;
            }
            User user = userMapper.selectByPrimaryKey(token.getUserId());
            AuthGroup authGroup = authGroupMapper.selectByPrimaryKey(user.getUserWorkgroup());
            String limitDevs = authGroup.getLimitContent();//查询限制查看的监视器
            AuthOpreator authOpreator = authOpreatorMapper.selectByPrimaryKey(user.getUserPosition());
            monitors.setMonitors(limitDevs);
            authCodeHolder.setAuthCode(authOpreator.getUserAuthority());
            userHolder.setUser(user);
        }
        return true;
    }

    /*
    渲染之前将用户信息填充到视图
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && userHolder.getUser() != null) {
            modelAndView.addObject("user", userHolder.getUser());
        }
    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        userHolder.clear();
    }
}
