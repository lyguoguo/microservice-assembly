package com.example.msdb.datasource.aspect;

import com.example.msdb.datasource.DSContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import java.util.List;

@Slf4j
@Aspect
@Order(1)
public class DataSourceAspect {

    /**
     * 切面启动时设置数据源从库列表名称
     * @param slaves
     */
    public DataSourceAspect(List<String> slaves){
        DSContextHolder.setSlaves(slaves);
    }

    @Pointcut("@annotation(com.example.msdb.datasource.annocation.Slave) && execution(* com.example.msdb.*.service.*.*(..))")
    public void readPointcut() { }

    @Pointcut("@annotation(com.example.msdb.datasource.annocation.Master) && execution(* com.example.msdb.*.service.*.*(..))")
    public void writePointcut() { }

    @Before("readPointcut()")
    public void readBefore(JoinPoint joinPoint) {
        DSContextHolder.slave();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.debug("{}.{} USE DATASOURCE SLAVE", className, methodName);
    }

    @After("readPointcut()")
    public void readAfter(JoinPoint joinPoint) {
        DSContextHolder.master();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.debug("{}.{} RESET DATASOURCE MASTER", className, methodName);
    }

    @Before("writePointcut()")
    public void writeBefore(JoinPoint joinPoint) {
        DSContextHolder.master();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.debug("{}.{} USE DATASOURCE MASTER", className, methodName);
    }

}