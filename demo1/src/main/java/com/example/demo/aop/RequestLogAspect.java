package com.example.demo.aop;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author PYB
 * @Date 2022/8/3 20:06
 * @Version 1.0
 */
@Aspect
@Component
public class RequestLogAspect {
    @Pointcut("execution(* com.example.demo..*.*(..))")
    public void webLog(){}
    @Before("webLog()")
    public void beforeLog(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("切面");
    }
    @AfterReturning(returning = "retuen",pointcut = "webLog()")
    public void afterReturning(Object retuen){
        String s = JSONObject.toJSONString(retuen);
        System.out.println(s);
        System.out.println((Student)retuen);
    }
}
