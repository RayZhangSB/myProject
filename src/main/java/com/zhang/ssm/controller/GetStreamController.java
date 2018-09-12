package com.zhang.ssm.controller;


import com.zhang.ssm.service.GetStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/line")
public class GetStreamController {

    @Autowired
    private GetStreamService getStreamService;

    @RequestMapping("/set")
    @ResponseBody
    public String setLine(String lineName,String rtspPath,String rtmpPath) {
        return getStreamService.setLine(lineName,rtspPath, rtmpPath);
    }

    @RequestMapping("/start")
    @ResponseBody
    public String startLine(String lineName) {
        return getStreamService.startLine(lineName);
    }

    @RequestMapping("/release")
    @ResponseBody
    public String releaseLine(String lineName) {
        return getStreamService.releaseLine(lineName);
    }

    @RequestMapping("/stop")
    @ResponseBody
    public String stopLine(String lineName) {
        return getStreamService.stopLine(lineName);
    }


    @RequestMapping("/startAll")
    @ResponseBody
    public String startAllLine() {
        return getStreamService.startAllLine();
    }



    @RequestMapping("/stopAll")
    @ResponseBody
    public String stopAllLine() {
        return getStreamService.stopAllLine();
    }

}
