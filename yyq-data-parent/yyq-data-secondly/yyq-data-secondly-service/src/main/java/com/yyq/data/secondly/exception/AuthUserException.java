package com.yyq.data.secondly.exception;

import com.yyq.base.support.enums.ResultEnum;
import com.yyq.base.support.exception.BaseException;

/**
 * Created by yangyunqi on 2017/7/19.
 */
public class AuthUserException extends BaseException {

    private static final long serialVersionUID = 9010277412788998827L;

    public AuthUserException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public AuthUserException(Integer code, String message) {
        super(code, message);
    }
}
