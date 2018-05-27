package com.zhang.ssm.Controller;

import com.zhang.ssm.Service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UploadPicController
 * @Description: 图片处理
 * @Author Raymond Zhang
 * @Date 2018/5/18 13:51
 * @Version 1.0
 **/
@Controller
@RequestMapping("/pic")
public class PicController {

    @Autowired
    private PictureService pictureService;

    @ResponseBody
    @RequestMapping("/upload")
    public String uploadPicture(@RequestParam(value = "doc") MultipartFile files,
                                HttpServletRequest request) {

        return pictureService.uploadPicture(files, request);
    }
//    private static final Logger LOGGER = LoggerFactory.getLogger(PicController.class);


    @RequestMapping("/download")
    public String picDownload() {
        return "";
    }
}
