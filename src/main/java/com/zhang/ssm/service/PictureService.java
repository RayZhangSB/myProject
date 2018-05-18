package com.zhang.ssm.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface PictureService {

    String uploadPicture(MultipartFile file, HttpServletRequest request);
}
