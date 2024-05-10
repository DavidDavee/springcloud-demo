package com.demo.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-10 21:02
 **/
@RestController
public class PayMicrometerController {
    /**
     * Micrometer(Sleuth)进行链路监控的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id) {
        return "Hello, 欢迎到来myMicrometer inputId:  " + id + " \t    服务返回:" + IdUtil.simpleUUID();
    }
}
