package com.zhang.ssm.service;

import javax.servlet.http.HttpServletRequest;

public interface AbDetectionService {


    String addLine(String lineName,String rtspPath,String rtmpPath);

    String changeLine(String lineName);

    String snapshot(String lineName);

    String freshAbImgShow(String lineName,HttpServletRequest request);

    String getAbnormalInfo();
}
