package com.yyq.project.product.service;

import com.yyq.project.product.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyunqi on 2017/7/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {

    @Autowired
    private CategoryService productCategoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory result = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1), result.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result = productCategoryService.findAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> result = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 3));
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("验证", 5);
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}