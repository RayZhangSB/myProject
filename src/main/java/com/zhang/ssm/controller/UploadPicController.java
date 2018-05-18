package com.zhang.ssm.controller;

import com.zhang.ssm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UploadPicController
 * @Description: 图片上传
 * @Author Raymond Zhang
 * @Date 2018/5/18 13:51
 * @Version 1.0
 **/
@Controller
public class UploadPicController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String uploadPicture(@RequestParam(value = "file", required = false) MultipartFile file,
                                HttpServletRequest request) {
        return pictureService.uploadPicture(file, request);
    }

    @RequestMapping("/download")
    public String picDownload() {
        return "";
    }
}