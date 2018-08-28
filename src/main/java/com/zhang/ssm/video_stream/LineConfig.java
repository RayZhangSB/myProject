package com.zhang.ssm.video_stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ConfigUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/3 18:19
 * @Version 1.0
 **/
public  class LineConfig {

    //线路名称与rtmp地址映射
    public static final Map< String,String> LINE_RTMP_ADDRs = new ConcurrentHashMap<String,String>();

    //rtmp推流地址与设备rtsp地址映射
    public static final Map< String,String> RTMP_RTSP = new ConcurrentHashMap<String, String>();


}
