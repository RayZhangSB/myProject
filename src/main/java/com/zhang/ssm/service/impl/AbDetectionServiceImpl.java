package com.zhang.ssm.service.impl;

import com.zhang.ssm.service.AbDetectionService;
import com.zhang.ssm.utils.ConfigUtil;
import com.zhang.ssm.utils.JsonUtil;
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
        if(ConfigUtil.LINE_RTMP_ADDRs.containsKey(lineName)){
            responseResult.setCode(1);
            responseResult.setMsg("the line had add before");
        }else {
            ConfigUtil.LINE_RTMP_ADDRs.put(lineName,rtmpPath);
            if(ConfigUtil.RTMP_RTSP.containsKey(rtmpPath)){
                responseResult.setMsg(" the corresponding rtsp source changed ");
            }
            ConfigUtil.RTMP_RTSP.put(rtmpPath,rtspPath);
        }

        return JsonUtil.objectToJson(responseResult);
    }

    public String changeLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        if(ConfigUtil.LINE_RTMP_ADDRs.containsKey(lineName)) {
            String rtmpS = ConfigUtil.LINE_RTMP_ADDRs.get(lineName);
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
