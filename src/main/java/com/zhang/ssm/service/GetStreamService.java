package com.zhang.ssm.service;

public interface GetStreamService {
    String startLine(String lineName);

    String stopLine(String lineName);

    String startAllLine();

    String stopAllLine();

    String setLine(String lineName, String rtspPath, String rtmpPath);


}
