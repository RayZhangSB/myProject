package com.zhang.ssm.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/18 17:10
 * @Version 1.0
 **/
public class DateUtil {
    private static SimpleDateFormat sdf;

    public static String format(Date date, String dataFormat) {

        sdf = new SimpleDateFormat(dataFormat);
        return sdf.format(date);
    }

    public static String format(Date date) {
        if (sdf != null) {
            return sdf.format(date);
        }
        return format(date, "yyyyMMddHHmm");
    }
}
