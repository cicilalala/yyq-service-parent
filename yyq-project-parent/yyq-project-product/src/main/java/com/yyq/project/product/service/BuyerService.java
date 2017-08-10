package com.yyq.project.product.service;

import com.yyq.project.product.dto.OrderDTO;

/**
 * Created by yangyunqi on 2017/8/10.
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
