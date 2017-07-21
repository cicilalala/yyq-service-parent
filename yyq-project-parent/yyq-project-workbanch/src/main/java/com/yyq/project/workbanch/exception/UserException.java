package com.yyq.project.workbanch.exception;

import com.yyq.base.support.enums.ResultEnum;
import com.yyq.base.support.exception.BaseException;

/**
 * Created by yangyunqi on 2017/7/21.
 */
public class UserException extends BaseException {

    public UserException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public UserException(Integer code, String message) {
        super(code, message);
    }
}
