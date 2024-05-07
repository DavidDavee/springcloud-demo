package com.demo.cloud.controller;

import com.demo.cloud.entities.Pay;
import com.demo.cloud.entities.PayDTO;
import com.demo.cloud.resp.ResultData;
import com.demo.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-04-29 23:01
 **/
@Tag(name = "支付微服务模块", description = "支付CRUD")
@Slf4j
@RestController
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    @PostMapping(value = "/add")
    public ResultData<Integer> addPay(@RequestBody Pay pay) {
        log.info("com.demo.cloud.controller.PayController.addPay.pay={}", pay);
        int i = payService.add(pay);
        return ResultData.success(i);
    }

    @Operation(summary = "删除", description = "删除支付流水方法")
    @DeleteMapping(value = "/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        return ResultData.success(payService.delete(id));
    }

    @Operation(summary = "修改", description = "修改支付流水方法")
    @PutMapping(value = "/update")
    public ResultData<Integer> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success(i);
    }

    @GetMapping(value = "/getAll")
    public ResultData<List<Pay>> getAll() {
        List<Pay> list = payService.getAll();
        return ResultData.success(list);
    }

    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    @GetMapping(value = "/{id}")
    public ResultData<PayDTO> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(pay, payDTO);
        return ResultData.success(payDTO);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/get/info")
    public String getInfoByConsul(@Value("${demo.info}") String s) {
        return s + "\t" + "port: " + port;
    }
}


