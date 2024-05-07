package com.demo.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.demo.cloud.apis.PayFeignApi;
import com.demo.cloud.entities.PayDTO;
import com.demo.cloud.resp.ResultData;
import com.demo.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-07 00:22
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/feign/pay/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try
        {
            System.out.println("调用开始-----: "+ DateUtil.now());
            resultData = payFeignApi.getPayInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("调用结束-----: "+ DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return payFeignApi.getPayInfo(id);
    }

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping(value = "/feign/pay/get/info")
    public String getInfoByConsul()
    {
        return payFeignApi.mylb();
    }

}
