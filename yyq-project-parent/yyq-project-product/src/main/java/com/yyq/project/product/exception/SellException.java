package com.yyq.project.product.exception;

import com.yyq.project.product.enums.ResultEnum;

/**
 * Created by yangyunqi on 2017/8/4.
 */
public class SellException extends RuntimeException {

    private Integer code;
    private String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
