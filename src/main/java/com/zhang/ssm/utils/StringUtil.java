package com.zhang.ssm.utils;

/**
 * @ClassName StringUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/6 19:18
 * @Version 1.0
 **/
public final class StringUtil {
    public static final String SEPARATOR = String.valueOf((char) 29);

    public static boolean isNotEmpty(String fileName) {
        return fileName != null && !("".equals(fileName));
    }

    public static String[] splitString(String str, String regex) {
        return str.split(regex);
    }
}
