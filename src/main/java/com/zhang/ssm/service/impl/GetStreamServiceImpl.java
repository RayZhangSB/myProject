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
        String msg;
        if (StringUtil.isNotEmpty(lineName)) {
            if (LineConfig.existLine(lineName)) {
                String rtmpPath = LineConfig.getObjPath(lineName);
                String rtspPath = LineConfig.getSourcePath(rtmpPath);
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
                msg = "there is no corresponding line,please input again or set a new line";
                LOGGER.info(msg);
                responseResult.setMsg(msg);
            }
        } else {
            responseResult.setCode(1);
            msg = "lineName is null for start line";
            LOGGER.info(msg);
            responseResult.setMsg(msg);
        }
        return JsonUtil.objectToJson(responseResult);
    }

    @Override
    public String stopLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        String msg;
        if (StringUtil.isNotEmpty(lineName)) {
            if (LineConfig.existLine(lineName)) {
                if (vFactory.getMap().containsKey(lineName)) {
                    vFactory.stop(lineName);
                }
                msg = "the line " + lineName + " stopped";
                LOGGER.info(msg);
                responseResult.setMsg(msg);
            } else {
                responseResult.setCode(1);
                msg = "there is no corresponding line to stop";
                LOGGER.info(msg);
                responseResult.setMsg(msg);
            }
        } else {
            responseResult.setCode(1);
            msg = "lineName is null for stop line";
            LOGGER.info(msg);
            responseResult.setMsg(msg);
        }
        return JsonUtil.objectToJson(responseResult);
    }

    @Override
    public String releaseLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        String msg;
        if (StringUtil.isNotEmpty(lineName)) {
            if (LineConfig.existLine(lineName)) {
                vFactory.release(lineName);
                msg = "the line " + lineName + " is released";
                LOGGER.info(msg);
                responseResult.setMsg(msg);

            } else {
                responseResult.setCode(1);
                msg = "there is no corresponding line to release";
                LOGGER.info(msg);
                responseResult.setMsg(msg);
            }
        } else {
            responseResult.setCode(1);
            msg = "lineName is null to release ";
            LOGGER.info(msg);
            responseResult.setMsg(msg);
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
        if (LineConfig.existLine(lineName) && vFactory.getMap().containsKey(lineName)) {
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
