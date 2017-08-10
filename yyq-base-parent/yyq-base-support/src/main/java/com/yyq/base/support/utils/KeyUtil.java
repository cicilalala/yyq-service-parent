package com.yyq.base.support.utils;

import java.util.Random;

/**
 * Created by yangyunqi on 2017/8/4.
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
