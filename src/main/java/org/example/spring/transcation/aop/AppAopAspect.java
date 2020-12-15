package org.example.spring.transcation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by hyq on 2020/12/15 17:25.
 */
@Aspect
@Component
public class AppAopAspect {
    //切入点表达式
    @Pointcut("execution(* org.example.spring.transcation.service.AppService.aop(..))")
    public void pc() {
    }

    //前置通知
    @Before(value = "pc()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法AOP前置通知");
    }

    //后置通知
    @After(value = "pc()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法AOP后置通知");
    }

    //返回通知
    @AfterReturning(value = "pc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法AOP返回通知，返回值为：" + result);
    }

    //异常通知
    @AfterThrowing(value = "pc()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法AOP异常通知，异常信息为：" + e.getMessage());
    }
}
