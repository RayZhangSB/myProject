package com.zhang.ssm.service.impl;

import com.zhang.ssm.mapper.LineInfoMapper;
import com.zhang.ssm.pojo.LineInfo;
import com.zhang.ssm.service.AbDetectionService;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.StringUtil;
import com.zhang.ssm.video_stream.LineConfig;
import com.zhang.ssm.video_stream.VideoStreamConverter;
import com.zhang.ssm.video_stream.VideoStreamFactory;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AbDetectionServiceImpl.class);

    @Autowired
    private LineInfoMapper lineInfoMapper;

    private static VideoStreamFactory vFactory;

    static {
        vFactory = VideoStreamFactory.getInstance();
    }

    public String addLine(String lineName,String rtspPath,String rtmpPath) {
        ResponseResult responseResult = ResponseResult.ok();
        if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName) || LineConfig.RTMP_RTSP.containsKey(rtmpPath)) {
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
              if(!videoStreamConverter.tryGetFirstFrame()) {
                  //抓取器测试不通过
              }
            vFactory.addNewLine( new ExecPushStreamThread(videoStreamConverter));
*/
            LineConfig.RTMP_RTSP.put(rtmpPath, rtspPath);
            LineInfo info = new LineInfo();
            info.setLineName(lineName);
            info.setSrcUrl(rtspPath);
            info.setStreamUrl(rtmpPath);
            lineInfoMapper.insert(info);
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

    public String snapshot(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        VideoStreamFactory factory = VideoStreamFactory.getInstance();
        VideoStreamConverter converter = factory.getConverter(lineName);
        String path = converter.startSnapshot();
        if (StringUtil.isEmpty(path)) {
            responseResult.setCode(1);
            responseResult.setMsg("snapshot failed");
        } else {

            responseResult.setMsg(path);
        }

        return JsonUtil.objectToJson(responseResult);

    }


    public String delLine(String lineName) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            vFactory.delVideoStreamConverter(lineName);
            String key2 = LineConfig.LINE_RTMP_ADDRs.get(lineName);
            LineConfig.RTMP_RTSP.remove(key2);
            LineConfig.LINE_RTMP_ADDRs.remove(lineName);
            lineInfoMapper.deleteByName(lineName);
        } catch (Exception e) {
            LOGGER.error("delete line failed" + e.getMessage());
            responseResult.setCode(1);
            responseResult.setMsg("delete line failed");
        }
        responseResult.setMsg("delete line sucess");
        return JsonUtil.objectToJson(responseResult);
    }


}
