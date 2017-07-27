package com.yyq.project.workbanch.utils;

import com.yyq.base.support.utils.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by yangyunqi on 2017/7/27.
 */
public class PasswordEncoderUtil implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return MD5Util.encode(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
