package com.zhang.ssm.utils;

import java.io.File;

/**
 * @ClassName FileUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/31 9:05
 * @Version 1.0
 **/
public final class FileUtil {
    public static final String HEAD_SAVE_DIR = File.separator + "images" + File.separator + "profile_pictures" + File.separator;


    public static String getFileSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }
}
