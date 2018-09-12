package com.zhang.ssm.service.impl;

import com.zhang.ssm.service.GetStreamService;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.StringUtil;
import com.zhang.ssm.video_stream.LineConfig;
import com.zhang.ssm.video_stream.VideoStreamConverter;
import com.zhang.ssm.video_stream.VideoStreamFactory;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetStreamServiceImpl implements GetStreamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetStreamServiceImpl.class);

    private static VideoStreamFactory vFactory;

    static {
        vFactory = VideoStreamFactory.getInstance();
    }

    @Override
    public String startLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        if (StringUtil.isNotEmpty(lineName)) {
            if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName)) {
                String rtmpPath = LineConfig.LINE_RTMP_ADDRs.get(lineName);
                String rtspPath = LineConfig.RTMP_RTSP.get(rtmpPath);
                responseResult.setData(rtmpPath);
                VideoStreamConverter streamConverter;
                if (vFactory.getMap().containsKey(lineName)) {
                    streamConverter = vFactory.getConverter(lineName);
                    if (streamConverter == null) {
                        vFactory.addConverterToMap(lineName, rtspPath, rtmpPath);
                        streamConverter = vFactory.getConverter(lineName);
                        String result = vFactory.addNewLine(streamConverter);
                        responseResult.setMsg(result);
                    } else {
                        String result = vFactory.addNewLine(streamConverter);
                        responseResult.setMsg(result);
                    }
                } else {
                    vFactory.addConverterToMap(lineName, rtspPath, rtmpPath);
                    streamConverter = vFactory.getConverter(lineName);
                    String result = vFactory.addNewLine(streamConverter);
                    responseResult.setMsg(result);
                }


            } else {
                responseResult.setCode(1);
                responseResult.setMsg("there is no corresponding line,please input again or set a new line");
            }
        } else {

            responseResult.setCode(1);
            responseResult.setMsg("lineName is null for start line");
        }
        return JsonUtil.objectToJson(responseResult);
    }

    @Override
    public String stopLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        if (StringUtil.isNotEmpty(lineName)) {
            if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName)) {
                if (vFactory.getMap().containsKey(lineName)) {
                    vFactory.stop(lineName);
                }
                responseResult.setMsg("the line " + lineName + " stopped");
            } else {
                responseResult.setCode(1);
                responseResult.setMsg("there is no corresponding line to stop");
            }
        } else {
            responseResult.setCode(1);
            responseResult.setMsg("lineName is null for stop line");
        }
        return JsonUtil.objectToJson(responseResult);
    }

    @Override
    public String releaseLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        if (StringUtil.isNotEmpty(lineName)) {
            if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName)) {
                vFactory.release(lineName);
                responseResult.setMsg("the line " + lineName + " is released");
            } else {
                responseResult.setCode(1);
                responseResult.setMsg("there is no corresponding line to release");
            }
        } else {
            responseResult.setCode(1);
            responseResult.setMsg("lineName is null to release ");
        }
        return JsonUtil.objectToJson(responseResult);
    }

    @Override
    public String startAllLine() {
        vFactory.startAllPush();
        return JsonUtil.objectToJson(ResponseResult.ok());
    }

    @Override
    public String stopAllLine() {
        vFactory.stopAllPush();
        return JsonUtil.objectToJson(ResponseResult.ok());
    }

    @Override
    public String setLine(String lineName, String rtspPath, String rtmpPath) {
        ResponseResult responseResult = ResponseResult.ok();
        if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName) && vFactory.getMap().containsKey(lineName)) {
            VideoStreamConverter streamConverter = vFactory.getConverter(lineName);
            streamConverter.stopAndRelease();
            vFactory.getMap().remove(lineName);
        } else {
            vFactory.addConverterToMap(lineName, rtspPath, rtmpPath);
        }
        LineConfig.addNewLineMap(lineName, rtspPath, rtmpPath);
//            ImageProcess.makeSaveDirs(lineName);
        responseResult.setMsg("the line set success");
        return JsonUtil.objectToJson(responseResult);
    }


}
