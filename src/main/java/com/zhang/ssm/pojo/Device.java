package com.zhang.ssm.pojo;

public class Device {
    private Integer devId;

    private String devName;

    private String devUrl;

    private Integer devPoint;

    private Integer devStatus;

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    public String getDevUrl() {
        return devUrl;
    }

    public void setDevUrl(String devUrl) {
        this.devUrl = devUrl == null ? null : devUrl.trim();
    }

    public Integer getDevPoint() {
        return devPoint;
    }

    public void setDevPoint(Integer devPoint) {
        this.devPoint = devPoint;
    }

    public Integer getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(Integer devStatus) {
        this.devStatus = devStatus;
    }
}