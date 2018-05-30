package com.zhang.ssm.service;

public interface RealMonitorDataService {

    int READABLE = 2;
    int UPDATABLE = 3;
    int ADDABLE = 5;
    int DELETABLE = 7;

    String getRealMonitorData();

    String getScope();
}
