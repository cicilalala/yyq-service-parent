package com.yyq.project.product.service;

import com.yyq.project.product.domain.OrderDetails;
import com.yyq.project.product.dto.OrderDTO;
import com.yyq.project.product.enums.OrderStatusEnum;
import com.yyq.project.product.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yangyunqi on 2017/8/4.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID = "10001";

    private final String ORDER_ID = "1501837744761958739";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO
                .setBuyerName("杨蕴琦")
                .setBuyerAddress("视觉中国")
                .setBuyerPhone("18519189497")
                .setBuyerOpenid(BUYER_OPENID);

        List<OrderDetails> orderDetailsList = new ArrayList<>();

        OrderDetails order1 = new OrderDetails();
        order1.setProductId("c199c9ed8b974e7da6da3fda372ddf36");
        order1.setProductQuantity(2);
        orderDetailsList.add(order1);

        OrderDetails order2 = new OrderDetails();
        order2.setProductId("f70d1835b9784afcaacb2e19bca6690e");
        order2.setProductQuantity(2);
        orderDetailsList.add(order2);

        orderDTO.setOrderDetailsList(orderDetailsList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单 result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("查询订单 result={}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void findList1() throws Exception {
        PageRequest request = new PageRequest(0, 5);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        Assert.assertTrue("查询订单的总数", orderDTOPage.getTotalElements() > 0);
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

}