package com.yyq.project.product.enums;

/**
 * Created by yangyunqi on 2017/7/28.
 */
public enum ProductStatusEnum {
    UP(0, "UP"),
    DOWN(1, "DOWN");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
