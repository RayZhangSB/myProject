package com.zhang.ssm.pojo;

public class Point {
    private Integer pointId;

    private String piontDesc;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getPiontDesc() {
        return piontDesc;
    }

    public void setPiontDesc(String piontDesc) {
        this.piontDesc = piontDesc == null ? null : piontDesc.trim();
    }
}