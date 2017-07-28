package com.yyq.project.product.service;

import com.yyq.project.product.domain.ProductCategory;

import java.util.List;

/**
 * Created by yangyunqi on 2017/7/28.
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
