package com.yyq.project.product.repository;

import com.yyq.base.support.utils.StrUtil;
import com.yyq.project.product.domain.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by yangyunqi on 2017/8/3.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private final String OPENID = "10001";

    @Test
    public void save() throws Exception {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster
                .setOrderId(StrUtil.randomUUID())
                .setBuyerName("杨蕴琦")
                .setBuyerPhone("18519189497")
                .setBuyerAddress("视觉中国")
                .setBuyerOpenid(OPENID)
                .setOrderAmount(new BigDecimal(30));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

}