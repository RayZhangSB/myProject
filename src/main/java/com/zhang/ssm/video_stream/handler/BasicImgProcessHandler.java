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

    private static final int BACKWARD_LENGTH = 8;

    private int val;

    private int maxVal = Integer.MIN_VALUE;

    private int idx = -1;

    private boolean abnormal_appear = false;

    private int initCount = 0;

    @Override
    public Object preProcess(opencv_core.Mat mat) {
        val = calculateVal(mat);
        updateVal(val);
        Object res = null;
        if (abnormal_appear) {
            if (backward.size() < BACKWARD_LENGTH) {
                if (val > maxVal) {
                    maxVal = val;
                    idx = backward.size();
                }
                backward.offer(mat);
            } else { //backward.size()==BACKWARD_LENGTH
                if (idx > 0) {
                    int i = 1;
                    for (opencv_core.Mat m : backward) {
                        if (i == idx) {
                            if (calculateValByBackGround(m, background)) {
                                res = m;
                            }
                            abnormal_appear = false;
                            for (int j = 0; j < BACKWARD_LENGTH - DIFF_INTERVAL; j++) {
                                backward.pollFirst();
                            }
                            break;
                        }
                        ++i;
                    }
                }
            }

        } else {
            if (DiffByInterval(mat)) {
                if (initCount == 10) {
                    background = mat;
                } else {
                    initCount++;
                }
                abnormal_appear = true;
            }
        }
        return res;
    }

    private int calculateIntervalDiff(LinkedList<Integer> queue) {
        int i = 0;
        int oldSum = 0;
        int newSum = 0;
        maxVal = Integer.MIN_VALUE;
        for (int j : queue) {
            if (i < DIFF_INTERVAL) {
                oldSum += j;
            }
            if (i > DIFF_INTERVAL) {
                if (maxVal < j) {
                    maxVal = j;
                    idx = i - DIFF_INTERVAL;
                }
                newSum += j;
            }
            i++;
        }
        return newSum - oldSum;
    }

    private int calculateVal(opencv_core.Mat mat) {
        return 0;
    }


    private boolean DiffByInterval(opencv_core.Mat mat) {
        updateBackward(mat);
        int diff = 0;
        if (queue.size() >= QUEUE_MAX_LENGTH) {
            diff = calculateIntervalDiff(queue);

        }
        return diff > DIFF_THRESHOLD;
    }

    private boolean calculateValByBackGround(opencv_core.Mat mat, opencv_core.Mat background) {
        //mat-background

        int backwardVal = val - 1;
        return backwardVal > BG_THRESHOLD;
    }

    private void updateVal(int val) {
        if (queue.size() >= QUEUE_MAX_LENGTH) {
            queue.pollFirst();
        }
        queue.offer(val);
    }

    private void updateBackward(opencv_core.Mat mat) {
        if (backward.size() >= DIFF_INTERVAL) {
            backward.pollFirst();
        }
        backward.offer(mat);
    }

}
