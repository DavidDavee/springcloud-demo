package com.demo.cloud.apis;

import com.demo.cloud.resp.ResultData;
import com.demo.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-05-24 22:32
 **/
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
