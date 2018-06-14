package com.zhang.ssm.video_stream;

import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.utils.DateUtil;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.RedisAdapter;
import com.zhang.ssm.utils.StringUtil;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ImageProcess
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/12 16:27
 * @Version 1.0
 **/
public class ImageProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageProcess.class);

    private static String AB_IMG_PATH_PREFIX = "/home/AB_IMG_SAVE";

    private static Map<String, String> savePaths = new HashMap<String, String>(128);

    private static AtomicInteger id_count = new AtomicInteger(4001) ;

    public boolean preProcess(opencv_core.Mat mat) {
//        opencv_imgproc
        return false;
    }


    public  void classify(opencv_core.Mat mat ,String lineName,Date date) {
        //将图片存储到某个目录，按时间点存储,将相关信息填入到redis
        String path = "";
        if(savePaths.containsKey(lineName) ){
            path = savePaths.get(lineName);
        }
        if(StringUtil.isNotEmpty(path)){
            String name =DateUtil.genTime(date,"yyyy_MM_dd_HH_mm_SS");
            path = path+File.separator+name+".jpg";
            opencv_imgcodecs.imwrite(path,mat);
            ShardedJedis sj= RedisAdapter.getRedisConn();
            AbnormalInfo ab_info  = new AbnormalInfo();
            ab_info.setId(id_count.get());
            ab_info.setCreateTime(date);
            ab_info.setAbnormalImgUrl(path);
            ab_info.setAbnormalCode(0);
            ab_info.setProcessed(0);
            sj.lpush(lineName+"_"+"unprocessed", JsonUtil.objectToJson(ab_info));
            id_count.incrementAndGet();
        }

    }


    public void process(opencv_core.Mat mat ,String lineName,Date date) {

        if(preProcess(mat)){
            classify(mat,lineName,date);
        }

    }


    public static String makeSaveDirs(String lineName) {
        if(savePaths.containsKey(lineName)){
            return savePaths.get(lineName);
        }
        String date = DateUtil.genTime(new Date(), "yyyy-MM-dd");
        File dir = new File(AB_IMG_PATH_PREFIX + File.separator + date);
        String saveDir = "";
        try {
            if (!(dir.exists() && dir.isDirectory())) {
                dir.mkdir();
            }
            saveDir = dir + File.separator + lineName;
            File sDir = new File(saveDir);
            if (!(sDir.exists() && sDir.isDirectory())) {
                sDir.mkdir();
                savePaths.put(lineName, saveDir);
            }
        } catch (Exception e) {
            LOGGER.error("存储异常图片的路径创建失败" + e.getMessage());
            return "";
        }
        return saveDir;
    }

}
