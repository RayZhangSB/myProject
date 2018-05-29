package com.zhang.ssm.wrapperPojo;

import org.springframework.stereotype.Component;

/**
 * @ClassName MonitorsHolder
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/29 14:29
 * @Version 1.0
 **/
@Component
public class MonitorsHolder {
    private ThreadLocal<String> monitors = new ThreadLocal<String>();

    public String getMonitors() {
        return monitors.get();
    }

    public void setMonitors(String s) {
        monitors.set(s);
    }

    public void clear() {
        monitors.remove();

    }


}
