package com.yyq.data.master.exception;

import com.yyq.base.support.enums.ResultEnum;
import com.yyq.base.support.exception.BaseException;

public class UserException extends BaseException {

    private static final long serialVersionUID = -4713963384329557381L;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public UserException(Integer code, String message) {
        super(code, message);
    }
}
