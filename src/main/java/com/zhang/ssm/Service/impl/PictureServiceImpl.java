package com.zhang.ssm.Service.impl;

import com.alibaba.fastjson.JSON;
import com.zhang.ssm.Service.PictureService;
import com.zhang.ssm.Utils.DateUtil;
import com.zhang.ssm.Utils.IDUtils;
import com.zhang.ssm.Utils.StringUtil;
import com.zhang.ssm.WrapperPOJO.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;


/**
 * 图片上传服务
 */
@Service
public class PictureServiceImpl implements PictureService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureServiceImpl.class);

    public String uploadPicture(MultipartFile file, HttpServletRequest request) {
        File targetFile = null;
        String msg = "";//返回存储路径
        int code = 1;
        String fileName = file.getOriginalFilename();//获取文件名加后缀
        if (StringUtil.isNotEmpty(fileName)) {
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName = IDUtils.genImageName();//新的文件名
            String newFileName = fileName + fileF;
            //先判断文件是否存在
            String fileAdd = DateUtil.genTime(new Date(), "yyyyMMdd");
            File saveDir = new File(savePathPrefix + File.separator + fileAdd + File.separator);
            String saveFileRefPath = saveDir + File.separator + newFileName;
            targetFile = new File(saveFileRefPath);
            if (!saveDir.exists() && !saveDir.isDirectory()) {
                try {
                    saveDir.mkdirs();
                } catch (Exception e) {
                    msg = "创建文件夹失败";
                    LOGGER.error(msg);
                }
            }
            try {
                file.transferTo(targetFile);
                code = 0;
                msg = saveFileRefPath;
            } catch (Exception e) {
                msg = "文件存储异常";
                LOGGER.error(msg);
            }
        }
        return JSON.toJSONString(ResponseResult.build(code, msg));
    }

}
