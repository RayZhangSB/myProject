package com.zhang.ssm.service.impl;

import com.zhang.ssm.service.ImageProcessService;
import org.bytedeco.javacpp.opencv_core;

/**
 * @ClassName BaseImgProcess
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/7 18:15
 * @Version 1.0
 **/
public class BaseImgProcess implements ImageProcessService {


    public boolean preProcess(opencv_core.Mat mat) {
//        opencv_imgproc
            return false;
    }


    public  void classify(opencv_core.Mat mat ,String path) {
        //将图片存储到某个目录，按天和按线路名存储


    }

    @Override
    public void process(opencv_core.Mat mat ,String mark) {

        if(preProcess(mat)){
             classify(mat,mark);
        }

    }
}
