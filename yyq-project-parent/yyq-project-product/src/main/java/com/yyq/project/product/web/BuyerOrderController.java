package com.yyq.project.product.web;

import com.yyq.project.product.VO.ResultVO;
import com.yyq.project.product.converter.OrderForm2OrderDTOConverter;
import com.yyq.project.product.dto.OrderDTO;
import com.yyq.project.product.enums.ResultEnum;
import com.yyq.project.product.exception.SellException;
import com.yyq.project.product.form.OrderForm;
import com.yyq.project.product.service.OrderService;
import com.yyq.project.product.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyunqi on 2017/8/8.
 */
@Slf4j
@RestController
@RequestMapping("buyer/order")
@Api(value = "买家订单", description = "买家订单")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    @ApiOperation(value = "创建订单", notes = "创建订单")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.covert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailsList())) {
            log.error("【创建订单】购物车为空, orderForm={}", orderForm);
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    @GetMapping("list")
    @ApiOperation(value = "查询所有订单", notes = "查询所有订单")
    public ResultVO list(@RequestParam(value = "openid") String openid,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }
}
