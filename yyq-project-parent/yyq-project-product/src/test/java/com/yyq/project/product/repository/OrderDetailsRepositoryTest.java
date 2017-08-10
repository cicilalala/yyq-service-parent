package com.yyq.project.product.repository;

import com.yyq.base.support.utils.StrUtil;
import com.yyq.project.product.domain.OrderDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yangyunqi on 2017/8/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailsRepositoryTest {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Test
    public void save() throws Exception {

        OrderDetails orderDetails = new OrderDetails();
        orderDetails
                .setOrderId(StrUtil.randomUUID())
                .setDetailId("9c150ab976594f2680796754b98436ea")
                .setProductIcon("http://xxx.jpg")
                .setProductId("c199c9ed8b974e7da6da3fda372ddf36")
                .setProductName("java")
                .setProductPrice(new BigDecimal(200))
                .setProductQuantity(2);

        OrderDetails result = orderDetailsRepository.save(orderDetails);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetails> result = orderDetailsRepository.findByOrderId("7e36e39b3de34de1a665f449fba275ea");
        Assert.assertNotEquals(0, result.size());
    }

}