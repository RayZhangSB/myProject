package com.zhang.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhang.ssm.WrapperPOJO.ResponseResult;
import com.zhang.ssm.mapper.ContentMapper;
import com.zhang.ssm.pojo.Content;
import com.zhang.ssm.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ContentServiceImpl
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/21 12:42
 * @Version 1.0
 **/
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;

    public String contentInsert(Content content) {
        int code = 0;
        String msg;
        int rows = contentMapper.insert(content);
        if (rows > 0) {
            msg = "笔记添加成功";
        }
        msg = "笔记添加失败";
        return JSON.toJSONString(ResponseResult.build(code, msg));
    }

    public String contentUpdate(Long contentId, Content content) {
        return null;
    }

    public String contentDelete(Long contentId) {
        return null;
    }

    public String contentSelectList(Long contentId) {
        return null;
    }
}
