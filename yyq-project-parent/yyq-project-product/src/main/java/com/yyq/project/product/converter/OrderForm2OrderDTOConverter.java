package com.yyq.project.product.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.yyq.project.product.domain.OrderDetails;
import com.yyq.project.product.dto.OrderDTO;
import com.yyq.project.product.enums.ResultEnum;
import com.yyq.project.product.exception.SellException;
import com.yyq.project.product.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by yangyunqi on 2017/8/8.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    
    public static OrderDTO covert(OrderForm orderForm) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO
                .setBuyerName(orderForm.getName())
                .setBuyerPhone(orderForm.getPhone())
                .setBuyerAddress(orderForm.getAddress())
                .setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetails> orderDetailsList;
        try {
            orderDetailsList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetails>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误，string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailsList(orderDetailsList);
        return orderDTO;
    }
}
