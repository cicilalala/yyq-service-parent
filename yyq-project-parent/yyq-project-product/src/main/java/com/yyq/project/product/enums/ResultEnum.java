package com.yyq.project.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yangyunqi on 2017/8/4.
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(0, "成功"),
    UNKNOW_ERROR(-1, "未知错误"),

    PARAM_ERROR(1, "参数不正确"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品没有库存"),
    PRODUCT_STATUS_ERROR(12, "商品状态不正确"),

    PRODUCT_UP_SUCCESS(13, "商品上架成功"),
    PRODUCT_DOWN_SUCCESS(14, "商品下架成功"),

    ORDER_NOT_EXIST(15, "订单不存在"),
    ORDER_DETAILS_NOT_EXIST(16, "订单详情不存在"),
    ORDER_STATUS_ERROR(17, "订单状态不正确"),
    ORDER_UPDATE_FAIL(18, "订单更新失败"),
    ORDER_DETAILS_EMPTY(19, "订单中没有商品详情"),
    ORDER_PAY_STATUS_ERROR(20, "订单支付状态不正确"),

    CART_EMPTY(21, "购物车为空"),

    ORDER_OWNER_ERROR(22, "该订单不属于当前用户"),

    ORDER_CANCEL_SUCCESS(23, "订单取消成功"),
    ORDER_FINISH_SUCCESS(24, "订单完结成功")
    ;

    private Integer code;

    private String message;
}
