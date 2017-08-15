package com.yyq.project.product.web;

import com.yyq.project.product.domain.ProductCategory;
import com.yyq.project.product.domain.ProductInfo;
import com.yyq.project.product.enums.ResultEnum;
import com.yyq.project.product.form.ProductForm;
import com.yyq.project.product.service.CategoryService;
import com.yyq.project.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyunqi on 2017/8/11.
 */
@Slf4j
@Controller
@RequestMapping("seller/product")
@Api(value = "卖家商品", description = "卖家商品")
public class SellProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    @ApiOperation(value = "查询所有商品", notes = "查询所有商品")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size, Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage =productService.findAll(pageRequest);
        log.info(productInfoPage.getContent().toString());
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("onSale")
    @ApiOperation(value = "商品上架", notes = "商品上架")
    public ModelAndView onSale(@RequestParam(value = "productId") String productId, Map<String, Object> map) {

        try {
            productService.onSale(productId);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            map.put("url", "/sell/seller/product/list");

            return new ModelAndView("common/error", map);
        }

        map.put("message", ResultEnum.PRODUCT_UP_SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("offSale")
    @ApiOperation(value = "商品下架", notes = "商品下架")
    public ModelAndView offSale(@RequestParam(value = "productId") String productId, Map<String, Object> map) {

        try {
            productService.offSale(productId);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("message", ResultEnum.PRODUCT_DOWN_SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("index")
    @ApiOperation(value = "商品修改", notes = "商品修改")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId, Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);
    }

    @PostMapping("save")
    @ApiOperation(value = "保存商品", notes = "保存商品")
    public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult, Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("message", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();

        try {
            if (!StringUtils.isEmpty(productForm.getProductId() == null)) {
                productInfo = productService.findOne(productForm.getProductId());
            }
            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
