package com.yyq.project.product.repository;

import com.yyq.base.support.utils.StrUtil;
import com.yyq.project.product.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yangyunqi on 2017/7/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo
                .setProductId(StrUtil.randomUUID())
                .setProductName("java")
                .setProductDescription("basic")
                .setProductIcon("xxx.jpg")
                .setProductPrice(new BigDecimal(100))
                .setCategoryType(1)
                .setProductStatus(0)
                .setProductStock(100);
        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> result = productInfoRepository.findByProductStatus(1);
        Assert.assertNotEquals(0, result.size());
    }

}