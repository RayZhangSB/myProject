package com.zhang.ssm.pojo;

public class AuthOpreator {
    private String authScope;

    private Integer userAuthority;

    public String getAuthScope() {
        return authScope;
    }

    public void setAuthScope(String authScope) {
        this.authScope = authScope == null ? null : authScope.trim();
    }

    public Integer getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        this.userAuthority = userAuthority;
    }
}