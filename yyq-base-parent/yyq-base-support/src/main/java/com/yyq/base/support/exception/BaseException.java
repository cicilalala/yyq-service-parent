package com.yyq.base.support.exception;

import com.yyq.base.support.enums.ResultEnum;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -5581446695761542231L;

    private Integer code;

    private String message;

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public BaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}