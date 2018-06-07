package com.zhang.ssm.service.impl;

import com.zhang.ssm.service.AbstractImgProcess;
import org.bytedeco.javacpp.opencv_core;

/**
 * @ClassName BaseImgProcess
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/7 18:15
 * @Version 1.0
 **/
public class BaseImgProcess extends AbstractImgProcess {
    @Override
    public void preProcess(opencv_core.IplImage img) {

    }

    @Override
    public int classify(opencv_core.IplImage img) {
        return 0;
    }


}
