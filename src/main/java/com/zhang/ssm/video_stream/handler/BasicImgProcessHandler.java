package com.zhang.ssm.video_stream.handler;

import com.zhang.ssm.video_stream.ImgProcessHandler;
import org.bytedeco.javacpp.opencv_core;

import java.util.LinkedList;

public class BasicImgProcessHandler implements ImgProcessHandler {

    private LinkedList<Integer> queue = new LinkedList<Integer>();

    private LinkedList<opencv_core.Mat> backward = new LinkedList<opencv_core.Mat>();

    private static final int QUEUE_MAX_LENGTH = 11;

    private static final int DIFF_THRESHOLD = 25;

    private static final int DIFF_INTERVAL = 5;

    private static opencv_core.Mat background;

    private static final int BG_THRESHOLD = 30;

    private int val;

    private int idx = -1;

    @Override
    public Object preProcess(opencv_core.Mat mat) {
        val = caulateVal(mat);
        if (DiffByInterval(mat)) {
            if (idx > 0) {
                int i = 1;
                for (opencv_core.Mat m : backward) {
                    if (i == idx) {
                        if (caulateValByBackGround(m, background)) {
                            return m;
                        }
                    }
                    ++i;
                }
            }

        }
        return null;
    }

    private int caulateIntervalDiff(LinkedList<Integer> queue) {
        int i = 0;
        int oldSum = 0;
        int newSum = 0;
        int max = Integer.MIN_VALUE;
        for (int j : queue) {
            if (i < DIFF_INTERVAL) {
                oldSum += j;
            }
            if (i > DIFF_INTERVAL) {
                if (max < j) {
                    max = j;
                    idx = i - DIFF_INTERVAL;
                }
                newSum += j;
            }
            i++;
        }
        return newSum - oldSum;
    }

    private int caulateVal(opencv_core.Mat mat) {
        return 0;
    }


    private boolean DiffByInterval(opencv_core.Mat mat) {

        int diff;
        if (queue.size() >= DIFF_INTERVAL) {
            backward.pollFirst();
        }
        backward.offer(mat);
        if (queue.size() >= QUEUE_MAX_LENGTH) {
            diff = caulateIntervalDiff(queue);
            queue.pollFirst();
            if (diff > DIFF_THRESHOLD) {
                return true;
            }
        }
        queue.offer(val);
        return false;
    }

    private boolean caulateValByBackGround(opencv_core.Mat mat, opencv_core.Mat background) {
        //mat-background
        int backwardVal = val - 1;
        return backwardVal > BG_THRESHOLD;
    }

}
