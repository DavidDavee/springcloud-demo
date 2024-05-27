package com.demo.cloud.controller;

import com.demo.cloud.entities.Order;
import com.demo.cloud.resp.ResultData;
import com.demo.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-27 00:04
 **/
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @PostMapping("/order/create")
    public ResultData create(@RequestBody Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}
