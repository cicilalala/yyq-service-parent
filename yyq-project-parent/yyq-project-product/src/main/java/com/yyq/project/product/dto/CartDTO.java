package com.yyq.project.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by yangyunqi on 2017/8/4.
 */
@Data
@Accessors(chain = true)
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
