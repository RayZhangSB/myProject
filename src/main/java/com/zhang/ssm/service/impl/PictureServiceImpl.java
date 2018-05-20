package com.zhang.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhang.ssm.Utils.DateUtil;
import com.zhang.ssm.Utils.IDUtils;
import com.zhang.ssm.Utils.StringUtil;
import com.zhang.ssm.WrapperPOJO.ResponseResult;
import com.zhang.ssm.service.PictureService;
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
    private String savePathPrefix = "F:" + File.separator + "learning" + File.separator + "upload" + File.separator + "img";//存储路径
//	@Value("${FTP_ADDRESS}")
//	private String FTP_ADDRESS;
//	@Value("${FTP_PORT}")
//	private String FTP_PORT;
//	@Value("${FTP_USERNAME}")
//	private String FTP_USERNAME;
//	@Value("${FTP_PASSWORD}")
//	private String FTP_PASSWORD;
//	@Value("${FTP_BASE_PATH}")
//	private String FTP_BASE_PATH;
//	@Value("${IMAGE_BASE_URL}")
//	private String IMAGE_BASE_URL;

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
            String fileAdd = DateUtil.format(new Date(), "yyyyMMdd");

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
        String res = JSON.toJSONString(ResponseResult.result(code, msg));
        return res;
    }

}
