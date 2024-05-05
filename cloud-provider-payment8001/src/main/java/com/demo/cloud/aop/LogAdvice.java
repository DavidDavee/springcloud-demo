package com.demo.cloud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAdvice {
    @Before("execution(* com..controller.*.*(..))")
    public void before(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String param = Arrays.asList(joinPoint.getArgs()).toString();
        log.info(className + "." + methodName + ".start." + param);
    }
}
