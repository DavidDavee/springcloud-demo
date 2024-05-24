package com.demo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-demo
 * @description: Empower授权规则，用来处理请求的来源
 * @author: David
 * @create: 2024-05-24 21:21
 **/
@RestController
@Slf4j
public class EmpowerController {
    @GetMapping(value = "/empower")
    public String requestSentinel4() {
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }
}
