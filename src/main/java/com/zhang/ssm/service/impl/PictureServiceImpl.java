package com.zhang.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhang.ssm.Utils.DateUtil;
import com.zhang.ssm.WrapperPOJO.ResponseResult;
import com.zhang.ssm.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Random;


/**
 * 图片上传服务
 */
@Service
public class PictureServiceImpl implements PictureService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureServiceImpl.class);
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
        LOGGER.debug("文件是：" + file.getName());
        String fileName = file.getOriginalFilename();//获取文件名加后缀
        if (fileName != null && !fileName.equals("")) {
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/imgs/";//存储路径
            LOGGER.debug("文件存储路径前缀是：" + returnUrl);
            String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;//新的文件名
            //先判断文件是否存在
            String fileAdd = DateUtil.format(new Date(), "yyyyMMdd");
            File file1 = new File(path + "/" + fileAdd);
            //如果文件夹不存在则创建
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdir();
            }
            targetFile = new File(file1, fileName);

            try {
                file.transferTo(targetFile);
                msg = returnUrl + fileAdd + "/" + fileName;
                code = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(ResponseResult.result(code, msg));
    }

}
