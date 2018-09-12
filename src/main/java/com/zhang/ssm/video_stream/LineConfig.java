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

    static {
        LINE_RTMP_ADDRs.put("线路7","rtmp://127.0.0.1/live/stream");
        RTMP_RTSP.put("rtmp://127.0.0.1/live/stream","rtsp://admin:ma12345678@192.168.1.88/h264/ch0/main/av_stream");

     }

     public static void addNewLineMap(String lineName,String rtspPath,String rtmpPath){
         LineConfig.LINE_RTMP_ADDRs.put(lineName, rtmpPath);
         LineConfig.RTMP_RTSP.put(rtmpPath, rtspPath);
     }


     public static void removeLineMap(String lineName){
         String key2 = LineConfig.LINE_RTMP_ADDRs.get(lineName);
         LineConfig.RTMP_RTSP.remove(key2);
         LineConfig.LINE_RTMP_ADDRs.remove(lineName);

     }



}
