package com.zhang.ssm.pojo;

import java.util.Date;

public class Log {
    private Integer logId;

    private Integer userId;

    private Integer logExectype;

    private String logResult;

    private Date logDuringtime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLogExectype() {
        return logExectype;
    }

    public void setLogExectype(Integer logExectype) {
        this.logExectype = logExectype;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult == null ? null : logResult.trim();
    }

    public Date getLogDuringtime() {
        return logDuringtime;
    }

    public void setLogDuringtime(Date logDuringtime) {
        this.logDuringtime = logDuringtime;
    }
}