package com.zhang.ssm.console_pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AvailableLines
 * @Description: 可用的监控线路标记，用于切换线路
 * @Author Raymond Zhang
 * @Date 2018/6/3 17:06
 * @Version 1.0
 **/
public class AvailableLines {
    private static final Map<String, String> availableLines = new HashMap<String, String>();

    static {
        //初始状态下添加试用点的监控线路信息
        availableLines.put("", "");
    }
}
