package com.zhang.ssm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/18 17:10
 * @Version 1.0
 **/
public final class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    private static SimpleDateFormat sdf;

    public static String genTime(Date date, String dataFormat) {

        sdf = new SimpleDateFormat(dataFormat);
        return sdf.format(date);
    }

    public static String genTime(Date date) {
        if (sdf != null) {
            return sdf.format(date);
        }
        return genTime(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date genFormatDate(Date date) {
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try {
            date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            LOGGER.error(e.getMessage() + "生成格式化时间失败");
        }
        return date;
    }
}
