package com.zhang.ssm.pojo;

public class Content {
    private Short noteId;

    private Long uid;

    private Byte cid;

    private String title;

    private String imgUrl;

    private String subTitle;

    private String desc;

    public Short getNoteId() {
        return noteId;
    }

    public void setNoteId(Short noteId) {
        this.noteId = noteId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

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
        this.title = title == null ? null : title.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}