package com.yyq.project.product.repository;

import com.yyq.project.product.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyunqi on 2017/7/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOne() throws Exception {
        ProductCategory result = productCategoryRepository.findOne(1);
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional // 在Test方法中，无论如何也会回滚
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("纪实", 2);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void update() throws Exception {
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        ProductCategory result = productCategory.setCategoryType(100);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        Assert.assertNotEquals(0, result.size());
    }

}