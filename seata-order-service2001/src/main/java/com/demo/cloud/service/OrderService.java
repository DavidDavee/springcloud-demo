package com.demo.cloud.service;

import com.demo.cloud.entities.Order;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-26 23:43
 **/
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
