package com.zhang.ssm.pojo;

public class Log {
    private Integer logId;

    private Integer userId;

    private Integer logExectype;

    private String logResult;

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
}