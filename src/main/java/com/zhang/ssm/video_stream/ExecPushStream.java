package com.zhang.ssm.video_stream;

/**
 * @ClassName ExecPushStream
 * @Description: 执行推流而创建的线程
 * @Author Raymond Zhang
 * @Date 2018/6/5 17:46
 * @Version 1.0
 **/
public class ExecPushStream implements Runnable {
    private VideoStreamConverter streamConverter;

    public ExecPushStream(VideoStreamConverter streamConverter) {
        this.streamConverter = streamConverter;
    }

    public void run() {
        streamConverter.startPushStream();
    }
}
