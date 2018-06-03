package com.zhang.ssm.console_pojo;

/**
 * @ClassName UserConfig
 * @Description: 控制台的诸多使用配置，跟用户有关连
 * @Author Raymond Zhang
 * @Date 2018/6/3 17:02
 * @Version 1.0
 **/
public class UserConfig {

    private String recordPath;
    private String crawlPicPath;
    private String captureFileFormat;

    public String getRecordPath() {
        return recordPath;
    }

    public void setRecordPath(String recordPath) {
        this.recordPath = recordPath;
    }

    public String getCrawlPicPath() {
        return crawlPicPath;
    }

    public void setCrawlPicPath(String crawlPicPath) {
        this.crawlPicPath = crawlPicPath;
    }

    public String getCaptureFileFormat() {
        return captureFileFormat;
    }

    public void setCaptureFileFormat(String captureFileFormat) {
        this.captureFileFormat = captureFileFormat;
    }
}
