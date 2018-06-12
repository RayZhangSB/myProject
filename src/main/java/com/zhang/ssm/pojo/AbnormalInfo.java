package com.zhang.ssm.pojo;

public class AbnormalInfo {
    private Integer id;

    private String lineName;

    private Integer abnormalCode;

    private String abnormalImgUrl;

    private Integer processed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public Integer getAbnormalCode() {
        return abnormalCode;
    }

    public void setAbnormalCode(Integer abnormalCode) {
        this.abnormalCode = abnormalCode;
    }

    public String getAbnormalImgUrl() {
        return abnormalImgUrl;
    }

    public void setAbnormalImgUrl(String abnormalImgUrl) {
        this.abnormalImgUrl = abnormalImgUrl == null ? null : abnormalImgUrl.trim();
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }
}