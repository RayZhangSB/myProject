package com.zhang.ssm.controller;

import com.zhang.ssm.WrapperPOJO.ContentWrapper;
import com.zhang.ssm.pojo.Content;
import com.zhang.ssm.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    public String contentAdd(@RequestParam String cid, @RequestParam String title, @RequestParam String imgUrl, @RequestParam String desc, HttpServletRequest request) {
        //Byte cid,String title,String imgUrl,String desc,Short noteId,Long uid,String subTitle
        Content content = null;


        content = ContentWrapper.build(Byte.valueOf(cid)
                , title, imgUrl, desc);
        return contentService.contentInsert(content);
    }

}
