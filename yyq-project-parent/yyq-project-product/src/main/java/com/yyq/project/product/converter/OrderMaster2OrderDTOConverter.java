package com.yyq.project.product.converter;

import com.yyq.project.product.domain.OrderMaster;
import com.yyq.project.product.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyunqi on 2017/8/4.
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO covert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> covert(List<OrderMaster> orderMasterList) {
        return orderMasterList
                .stream()
                .map(e -> covert(e))
                .collect(Collectors.toList());
    }
}
