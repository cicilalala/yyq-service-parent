package com.yyq.project.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yangyunqi on 2017/8/3.
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements CodeEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完成"),
    CANCEL(2, "已取消");

    private Integer code;

    private String message;
}
