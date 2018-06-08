package com.zhang.ssm.pojo;

public class AbnormalInfo {
    private Integer id;

    private Integer devId;

    private Integer abnormalCode;

    private String abnormalImgurl;

    private String abnormalDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Integer getAbnormalCode() {
        return abnormalCode;
    }

    public void setAbnormalCode(Integer abnormalCode) {
        this.abnormalCode = abnormalCode;
    }

    public String getAbnormalImgurl() {
        return abnormalImgurl;
    }

    public void setAbnormalImgurl(String abnormalImgurl) {
        this.abnormalImgurl = abnormalImgurl == null ? null : abnormalImgurl.trim();
    }

    public String getAbnormalDesc() {
        return abnormalDesc;
    }

    public void setAbnormalDesc(String abnormalDesc) {
        this.abnormalDesc = abnormalDesc == null ? null : abnormalDesc.trim();
    }
}