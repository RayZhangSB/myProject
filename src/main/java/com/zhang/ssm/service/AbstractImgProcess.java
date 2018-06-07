package com.zhang.ssm.service;

import org.bytedeco.javacpp.opencv_core;

/**
 * @ClassName AbstractImgProcess
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/7 17:47
 * @Version 1.0
 **/
public abstract class AbstractImgProcess implements ImageProcessService {
    @Override
    public int process(opencv_core.IplImage img) {
        preProcess(img);
        return classify(img);
    }

    public abstract void preProcess(opencv_core.IplImage img);

    public abstract int classify(opencv_core.IplImage img);


}
