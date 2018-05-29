package com.zhang.ssm.pojo;

public class AuthGroup {
    private String authGroup;

    private String limitContent;

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup == null ? null : authGroup.trim();
    }

    public String getLimitContent() {
        return limitContent;
    }

    public void setLimitContent(String limitContent) {
        this.limitContent = limitContent == null ? null : limitContent.trim();
    }
}