package com.zhang.ssm.video_stream;

import org.bytedeco.javacpp.opencv_core;

public interface ImgProcessHandler {
    Object preProcess(opencv_core.Mat mat);


}
