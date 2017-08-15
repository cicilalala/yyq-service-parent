package com.yyq.project.product.web;

import com.yyq.project.product.dto.OrderDTO;
import com.yyq.project.product.enums.ResultEnum;
import com.yyq.project.product.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by yangyunqi on 2017/8/10.
 */
@Slf4j
@Controller
@RequestMapping("seller/order")
@Api(value = "卖家订单", description = "卖家订单")
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("list")
    @ApiOperation(value = "查询所有商品", notes = "查询所有商品")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size, Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    @GetMapping("cancel")
    @ApiOperation(value = "取消订单", notes = "取消订单")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (Exception e) {
            log.error("【取消订单】发生异常，orderId={}", orderId);

            map.put("message", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("message", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("detail")
    @ApiOperation(value = "订单详情", notes = "订单详情")
    public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map) {

        OrderDTO orderDTO;

        try {
            orderDTO = orderService.findOne(orderId);
        } catch (Exception e) {
            log.error("【订单详情】发生异常，orderId={}", orderId);
            map.put("message", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    @GetMapping("finish")
    @ApiOperation(value = "完结订单", notes = "完结订单")
    public ModelAndView finish(@RequestParam("orderId") String orderId, Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (Exception e) {
            log.error("【完结订单】发生异常，orderId={}", orderId);

            map.put("message", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("message", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
