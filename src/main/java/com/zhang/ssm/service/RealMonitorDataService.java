package com.zhang.ssm.service;

import com.zhang.ssm.pojo.User;

public interface RealMonitorDataService {

    int READABLE = 2;
    int UPDATABLE = 3;
    int ADDABLE = 5;
    int DELETABLE = 7;

    String getRealMonitorData(User user);

}
