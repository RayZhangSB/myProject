package com.zhang.ssm.pojo;

import java.util.Date;

public class Token {
    private Integer tokenId;

    private Integer userId;

    private Date tokenExpired;

    private Integer tokenStatus;

    private String tokenTicket;

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(Date tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Integer getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(Integer tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getTokenTicket() {
        return tokenTicket;
    }

    public void setTokenTicket(String tokenTicket) {
        this.tokenTicket = tokenTicket == null ? null : tokenTicket.trim();
    }
}