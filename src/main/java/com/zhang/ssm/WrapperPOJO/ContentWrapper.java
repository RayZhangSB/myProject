package com.zhang.ssm.WrapperPOJO;

import com.zhang.ssm.Utils.IDUtils;
import com.zhang.ssm.pojo.Content;

/**
 * @ClassName ContentWrapper
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/21 14:55
 * @Version 1.0
 **/
public class ContentWrapper {
    private static Content content;

    public Content getContent() {
        return content;
    }

    public static Content build(Byte cid, String title, String imgUrl, String desc) {
        return build(cid, title, imgUrl, desc, null, null, null);
    }

    public static Content build(Byte cid, String title, String imgUrl, String desc, Short noteId, Long uid, String subTitle) {
        if (content == null) {
            content = new Content();
        }
        content.setCid(cid);
        content.setTitle(title);
        content.setImgUrl(imgUrl);
        content.setDesc(desc);
        content.setNoteId(noteId);
        if (uid == null) {
            uid = IDUtils.genItemId();
        }
        content.setUid(uid);
        content.setSubTitle(subTitle);
        return content;
    }

}
