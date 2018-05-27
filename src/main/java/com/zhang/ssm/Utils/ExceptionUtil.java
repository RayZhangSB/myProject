package com.zhang.ssm.Utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class ExceptionUtil {

    /**
     * 获取异常的堆栈信息
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
