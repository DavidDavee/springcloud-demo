package com.demo.cloud.apis;

import com.demo.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-26 23:19
 **/
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {
    //扣减账户余额
    @GetMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
