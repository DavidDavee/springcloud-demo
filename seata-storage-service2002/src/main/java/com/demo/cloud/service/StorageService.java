package com.demo.cloud.service;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-27 00:16
 **/
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
