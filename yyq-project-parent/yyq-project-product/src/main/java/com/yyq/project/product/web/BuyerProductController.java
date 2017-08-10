package com.yyq.project.product.web;

import com.yyq.project.product.VO.ProductInfoVO;
import com.yyq.project.product.VO.ProductVO;
import com.yyq.project.product.VO.ResultVO;
import com.yyq.project.product.domain.ProductCategory;
import com.yyq.project.product.domain.ProductInfo;
import com.yyq.project.product.service.CategoryService;
import com.yyq.project.product.service.ProductService;
import com.yyq.project.product.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyunqi on 2017/8/3.
 */
@RestController
@RequestMapping("buyer/product")
@Api(value = "买家商品", description = "买家商品")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService productCategoryService;

    @GetMapping("list")
    @ApiOperation(value = "查询所有商品", notes = "查询所有商品")
    public ResultVO list() {

        List<ProductInfo> productInfoList = productService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO
                    .setCategoryType(productCategory.getCategoryType())
                    .setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
