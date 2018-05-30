package com.zhang.ssm.utils;

import java.util.ArrayList;

/**
 * @ClassName AuthUtil
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/28 20:02
 * @Version 1.0
 **/
public final class AuthUtil {


    /*
       权限码解析
        */
    public static ArrayList<Integer> parseAuthCode(Integer authCode) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        if (authCode == null) {
            return primes;
        }
        if (authCode % 2 == 0) {
            primes.add(2);
        }
        if (authCode % 3 == 0) {
            primes.add(3);
        }
        if (authCode % 5 == 0) {
            primes.add(5);
        }
        if (authCode % 7 == 0) {
            primes.add(7);
        }

        return primes;
    }


}
