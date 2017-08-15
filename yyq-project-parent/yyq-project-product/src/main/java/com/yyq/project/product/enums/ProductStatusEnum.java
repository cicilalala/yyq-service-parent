package com.yyq.project.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yangyunqi on 2017/7/28.
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "UP"),
    DOWN(1, "DOWN");

    private Integer code;

    private String message;
}
