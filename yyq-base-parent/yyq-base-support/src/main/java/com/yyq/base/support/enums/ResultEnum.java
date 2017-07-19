package com.yyq.base.support.enums;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public enum ResultEnum {

    SUCCESS(200, "成功"),
    UNKNOW_ERROR(500, "未知错误"),
    UNABLE_GET_SERVICE(503, "无法获得服务");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
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
