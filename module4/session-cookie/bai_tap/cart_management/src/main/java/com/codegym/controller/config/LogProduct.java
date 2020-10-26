package com.codegym.controller.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@Aspect
public class LogProduct {
    @Bean
    @AfterThrowing(pointcut = "execution(public *  com.codegym.service.ProductService.*(..))", throwing = "e")
    public void errorLog(JoinPoint joinPoint, Exception e) {
        String className=joinPoint.getTarget().getClass().getSimpleName();
        String returnType=joinPoint.getSignature().getDeclaringType().getName();
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());
        System.out.printf("Something was wrong: %s.%s.%s.%s : %s",className,returnType,method,args, e.getMessage());

    }
}
