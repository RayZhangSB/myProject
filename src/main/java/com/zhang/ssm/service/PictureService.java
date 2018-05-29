package com.zhang.ssm.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public interface PictureService {
    String savePathPrefix = "F:" + File.separator + "learning" + File.separator + "upload" + File.separator + "img";//存储路径

    String uploadPicture(MultipartFile file, HttpServletRequest request);
}
