package com.yyq.project.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by yangyunqi on 2017/8/3.
 */
@Data
@Accessors(chain = true)
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("class")
    private List<ProductInfoVO> productInfoVOList;
}
