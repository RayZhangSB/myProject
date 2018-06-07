package com.zhang.ssm.service;

import org.bytedeco.javacpp.opencv_core;

public interface ImageProcessService {

    int process(opencv_core.IplImage img);



}
