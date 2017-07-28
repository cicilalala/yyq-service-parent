package com.yyq.project.product.service;

import com.yyq.base.support.utils.StrUtil;
import com.yyq.project.product.domain.ProductInfo;
import com.yyq.project.product.enums.ProductStatusEnum;
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
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yangyunqi on 2017/7/28.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo result = productInfoService.findOne("c199c9ed8b974e7da6da3fda372ddf36");
        Assert.assertEquals("c199c9ed8b974e7da6da3fda372ddf36", result.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> result = productInfoService.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> page = productInfoService.findAll(pageRequest);
        log.info("" + page.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo
                .setProductId(StrUtil.randomUUID())
                .setProductName("javascript")
                .setProductDescription("basic")
                .setProductIcon("xxx.jpg")
                .setProductPrice(new BigDecimal(50))
                .setCategoryType(1)
                .setProductStatus(ProductStatusEnum.DOWN.getCode())
                .setProductStock(100);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }

}