package com.zhang.ssm.service.impl;

import com.zhang.ssm.service.AbDetectionService;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.LineConfig;
import com.zhang.ssm.utils.StringUtil;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @ClassName AbDetectionServiceImpl
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/3 18:24
 * @Version 1.0
 **/
@Service
public class AbDetectionServiceImpl implements AbDetectionService {


    public String addLine(String lineName,String rtspPath,String rtmpPath) {
        ResponseResult responseResult = ResponseResult.ok();
        if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName)) {
            responseResult.setCode(1);
            responseResult.setMsg("the line had add before");
        }else {
            LineConfig.LINE_RTMP_ADDRs.put(lineName, rtmpPath);
/*
            //这里新建一个线路的视频流转换器
            VideoStreamFactory vFactory = VideoStreamFactory.getInstance();
            FrameGrabber grabber =  vFactory.createDefaultGrabber(rtspPath,"tcp");
            FrameRecorder recorder =  vFactory.createDefaultRecorder(rtmpPath);
            OpenCVFrameConverter.ToIplImage converter = vFactory.createConverter();
            VideoStreamConverter videoStreamConverter =  vFactory.createVideoStreamConverter(lineName,grabber,recorder,converter);
            ExecPushStream pushStream = new ExecPushStream(videoStreamConverter);
            vFactory.addLine(pushStream);
*/
            if (LineConfig.RTMP_RTSP.containsKey(rtmpPath)) {
                responseResult.setMsg(" the corresponding rtsp source changed ");
            }
            LineConfig.RTMP_RTSP.put(rtmpPath, rtspPath);
        }

        return JsonUtil.objectToJson(responseResult);
    }

    public String changeLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName)) {
            String rtmpS = LineConfig.LINE_RTMP_ADDRs.get(lineName);
            if(StringUtil.isNotEmpty(rtmpS)) {
                responseResult.setData(rtmpS);
            }
            else{
                responseResult.setCode(1);
                responseResult.setMsg("No available video source ");
            }

        }else{
            responseResult.setCode(1);
            responseResult.setMsg("invalid line");
        }
        return JsonUtil.objectToJson(responseResult);
    }
}
