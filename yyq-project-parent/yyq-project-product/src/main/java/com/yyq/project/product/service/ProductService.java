package com.yyq.project.product.service;

import com.yyq.project.product.domain.ProductInfo;
import com.yyq.project.product.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by yangyunqi on 2017/7/28.
 */
public interface ProductService {

    /** 查询单个商品 */
    ProductInfo findOne(String productId);

    /** 查询上架商品 */
    List<ProductInfo> findUpAll();

    /** 查询所有商品 */
    Page<ProductInfo> findAll(Pageable pageable);

    /** 保存 */
    ProductInfo save(ProductInfo productInfo);

    /** 增加库存 */
    void increaseStock(List<CartDTO> cartDTOList);

    /** 减少库存 */
    void decreaseStock(List<CartDTO> cartDTOList);

    /** 上架商品 */
    ProductInfo onSale(String productId);

    /** 下架商品 */
    ProductInfo offSale(String productId);
}
