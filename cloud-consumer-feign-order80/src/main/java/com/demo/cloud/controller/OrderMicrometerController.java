package com.demo.cloud.controller;

import com.demo.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-demo
 * @description: Micrometer 替代 Sleuth
 * @author: David
 * @create: 2024-05-10 21:07
 **/
@RestController
@Slf4j
public class OrderMicrometerController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        return payFeignApi.myMicrometer(id);
    }
}
