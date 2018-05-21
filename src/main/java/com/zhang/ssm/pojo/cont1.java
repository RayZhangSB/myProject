package com.zhang.ssm.pojo;

/**
 * @ClassName cont1
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/21 19:15
 * @Version 1.0
 **/
public class cont1 {
    private Byte cid;

    private String title;

    private String imgUrl;
    private String desc;

    public Byte getCid() {
        return cid;
    }

    public void setCid(Byte cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
