package com.example.msdb.aspect;

import com.example.msdb.datasource.DBContextHolder;
import com.example.msdb.enums.DBTypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Aspect
@Component
@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataSourceAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.example.msdb.aspect.DataSource) " +
            "|| @within(com.example.msdb.aspect.DataSource)")
    public void dataSourcePointCut() {
        logger.debug("dataSourcePointCut in");
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class targetClass = point.getTarget().getClass();
        Method method = signature.getMethod();

        DataSource targetDataSource = (DataSource) targetClass.getAnnotation(DataSource.class);
        DataSource methodDataSource = method.getAnnotation(DataSource.class);
        if (targetDataSource != null || methodDataSource != null) {
            DBTypeEnum value;
            if (methodDataSource != null) {
                value = methodDataSource.value();
            } else {
                value = targetDataSource.value();
            }

            DBContextHolder.setDb(value);
            logger.debug("set datasource is {}", value);
        }

        try {
            return point.proceed();
        } finally {
            DBContextHolder.remove();
            logger.debug("clean datasource");
        }
    }
}