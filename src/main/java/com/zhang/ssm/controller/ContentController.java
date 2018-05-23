package com.zhang.ssm.controller;

import com.zhang.ssm.pojo.Content;
import com.zhang.ssm.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ItemController
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/17 17:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String contentAdd(Content cont) {

        return contentService.contentInsert(cont);
    }

    @RequestMapping("/list")
    public String contentSowList() {
        return "";
    }




}
