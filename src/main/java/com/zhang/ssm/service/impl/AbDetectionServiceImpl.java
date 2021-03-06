package com.zhang.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhang.ssm.mapper.AbnormalInfoMapper;
import com.zhang.ssm.mapper.LineInfoMapper;
import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.pojo.AbnormalInfoExample;
import com.zhang.ssm.pojo.LineInfo;
import com.zhang.ssm.service.AbDetectionService;
import com.zhang.ssm.utils.FileUtil;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.RedisAdapter;
import com.zhang.ssm.utils.StringUtil;
import com.zhang.ssm.video_stream.ImageProcess;
import com.zhang.ssm.video_stream.LineConfig;
import com.zhang.ssm.video_stream.VideoStreamConverter;
import com.zhang.ssm.video_stream.VideoStreamFactory;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

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
    private AbnormalInfoMapper abnormalInfoMapper;

    @Autowired
    private LineInfoMapper lineInfoMapper;

    private static VideoStreamFactory vFactory;

    static {
        vFactory = VideoStreamFactory.getInstance();
    }

    public String addLine(String lineName, String rtspPath, String rtmpPath) {
        ResponseResult responseResult = ResponseResult.ok();
        if (LineConfig.LINE_RTMP_ADDRs.containsKey(lineName) || LineConfig.RTMP_RTSP.containsKey(rtmpPath)) {
            responseResult.setCode(1);
            responseResult.setMsg("the line had add before");
        } else {
            LineConfig.addNewLineMap(lineName, rtspPath, rtmpPath);
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

            ImageProcess.makeSaveDirs(lineName);
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
            if (StringUtil.isNotEmpty(rtmpS)) {
                responseResult.setData(rtmpS);
            } else {
                responseResult.setCode(1);
                responseResult.setMsg("No available video source ");
            }
        } else {
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
            LineConfig.removeLineMap(lineName);
            lineInfoMapper.deleteByName(lineName);
        } catch (Exception e) {
            LOGGER.error("delete line failed" + e.getMessage());
            responseResult.setCode(1);
            responseResult.setMsg("delete line failed");
        }
        responseResult.setMsg("delete line sucess");
        return JsonUtil.objectToJson(responseResult);
    }

    public String freshAbImgShow(String lineName, HttpServletRequest request) {
        ResponseResult responseResult = ResponseResult.ok();
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String savePath = sc.getRealPath(FileUtil.AB_IMG_DIR) + File.separator;
        ShardedJedis sj = RedisAdapter.getRedisConn();
        String key = lineName + "_" + "processed";
        List<String> ab_infos = sj.lrange(key, -3, -1);
        int len = ab_infos.size();
        if (len == 0) {
            responseResult.setCode(1);
        } else {
            for (int i = 0; i < len; i++) {
                String ab_info = ab_infos.get(i);
                if (StringUtil.isNotEmpty(ab_info)) {
                    AbnormalInfo ab = JsonUtil.jsonToPojo(ab_info, AbnormalInfo.class);
                    String img = ab.getAbnormalImgUrl();
                    abnormalInfoMapper.insert(ab);
                    String dest = savePath + File.separator + String.valueOf(i + 4 - len) + ".jpg";
                    FileUtil.uploadImageFromLocal(img, dest);
                }
                sj.rpop(key);
            }
            responseResult.setMsg("detect new abnormal event");
        }
        sj.close();
        return JsonUtil.objectToJson(responseResult);
    }

    public String getAbnormalInfo() {
        ResponseResult responseResult = ResponseResult.ok();
        String res = null;
        try {
            List<AbnormalInfo> dat = abnormalInfoMapper.selectByExample(new AbnormalInfoExample());
            res = JSON.toJSONStringWithDateFormat(dat, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        } catch (Exception e) {
            responseResult.setCode(1);
            responseResult.setMsg("fetch Abnormal Info error" + e.getMessage());
        }

        responseResult.setData(res);
        return JsonUtil.objectToJson(responseResult);
    }
/*
    private ResponseResult prepareForStart() {
        ResponseResult responseResult = ResponseResult.ok();
        StringBuilder msg = new StringBuilder();
        List<String> result1 = vFactory.startPreparing();
        List<String> result2 = vFactory.checkSourceByGrab();
        boolean b1 = result1.size() < 1;
        boolean b2 = result2.size() < 1;
        if (b1 && b2) {
            responseResult.setMsg("All line are ready");
        } else {
            responseResult.setCode(2);
            if (!b1) {
                for (String s : result1) {
                    msg.append(s);
                    msg.append(",");
                }
                responseResult.setMsg("following lines can't contact success :" + msg);
            } else {
                for (String s : result2) {
                    msg.append(s);
                    msg.append(",");
                }
                responseResult.setMsg("following lines can't grab a frame :" + msg);
            }
        }
        return responseResult;

    }
*/
    public String start() {
        ResponseResult prepareResult =ResponseResult.ok();
        String resultMsg = vFactory.startAllPush();
        prepareResult.setMsg(resultMsg);
        return JsonUtil.objectToJson(prepareResult);
    }

    public void stop(){
        vFactory.stopAllPush();
    }

}
