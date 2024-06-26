package com.demo.cloud.exp;

import com.demo.cloud.resp.ResultData;
import com.demo.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: springboot-demo
 * @description:
 * @author: David
 * @create: 2024-04-17 23:56
 **/

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> myRuntimeException(RuntimeException e) {
        log.error("内部错误:{}", e.getMessage(), e.fillInStackTrace(), e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = NoFallbackAvailableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> myNoFallbackAvailableException(RuntimeException e) {
        log.error("内部错误:{}", e.getMessage(), e.fillInStackTrace(), e);
        return ResultData.fail(ReturnCodeEnum.RC404.getCode(), ReturnCodeEnum.RC404.getMessage());
    }
}
