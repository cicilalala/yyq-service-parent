package com.yyq.data.mongo.exception;

import com.yyq.base.support.enums.ResultEnum;
import com.yyq.base.support.exception.BaseException;

/**
 * Created by yangyunqi on 2017/5/15.
 */
public class FileException extends BaseException {

    private static final long serialVersionUID = 5080235335559478018L;

    public FileException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public FileException(Integer code, String message) {
        super(code, message);
    }
}
