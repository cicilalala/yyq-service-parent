package com.yyq.project.product.utils;

import com.yyq.project.product.enums.CodeEnum;

/**
 * Created by yangyunqi on 2017/8/10.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
