package com.ypvoid;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Yuanping on 2017/12/13.
 */
//声明一个Aspect类，并把该类放入Spring IOC容器
@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(public * com.ypvoid..*.*(..))")
    public void webLog() {
    }

    /**
     * 方法执行之前
     * @param joinPoint
     */
    @Before("webLog()")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("name=" + name + ",args:" + joinPoint.getArgs());
        System.out.println("beforeMethod.....");
    }

    /**
     * 方法执行，无论是否有异常
     * @param joinPoint
     */
    @After("webLog()")
    public void afterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("name=" + name);
        System.out.println("afterMethod.....");
    }

    /**
     * 后置返回通知
     * @param joinPoint
     */
    @AfterReturning(value = "webLog()",returning = "result")
    public void afterReturningMehtod(JoinPoint joinPoint,Object result) {
        System.out.println("result:" + result);
        System.out.println("afterReturningMethod.....");
    }

    /**
     * 后置异常通知
     * @param joinPoint
     */
    @AfterThrowing(value = "webLog()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex) {
        System.out.println(ex.getMessage());
        System.out.println("afterThrowing......");
    }
}


























