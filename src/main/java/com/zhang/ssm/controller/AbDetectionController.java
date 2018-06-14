package com.zhang.ssm.controller;

import com.zhang.ssm.service.AbDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AbDetectionController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/3 14:48
 * @Version 1.0
 **/
@Controller
@RequestMapping("/detect")
public class AbDetectionController {

    @Autowired
    private AbDetectionService abDetectionService;

    @RequestMapping("/addLine")
    @ResponseBody
    public String addLine(String lineName,String rtspPath,String rtmpPath) {
        return abDetectionService.addLine(lineName,rtspPath, rtmpPath);
    }


    @RequestMapping("/changeLine")
    @ResponseBody
    public String changeLine(String lineName){
        return abDetectionService.changeLine(lineName);
    }

    @RequestMapping("/snapshot")
    @ResponseBody
    public String snapshot(String lineName) {
        return abDetectionService.snapshot(lineName);
    }

    @RequestMapping("/freshAbImgShow")
    @ResponseBody
    public String freshAbImgShow(String lineName, HttpServletRequest request){
        return abDetectionService.freshAbImgShow(lineName,request);
    }

}
