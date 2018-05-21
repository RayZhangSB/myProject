package com.zhang.ssm.service;

import com.zhang.ssm.pojo.Content;

public interface ContentService {
    String contentInsert(Content content);

    String contentUpdate(Long contentId, Content content);

    String contentDelete(Long contentId);

    String contentSelectList(Long contentId);
}
