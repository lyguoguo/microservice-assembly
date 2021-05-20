package com.gly.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;
import java.util.concurrent.*;

@Aspect
@Component
public class TestAspect {
    private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    private Thread thread = new Thread();

//    @Pointcut("execution(public * com.gly.test..*Controller.*(..))")
    @Pointcut("@annotation(com.gly.test.aspect.MyAnnotation)")
    public void addAdvice(){}

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint point){
        logger.info("开始执行业务方法=====================");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("time-task");

        final ExecutorService exec = Executors.newFixedThreadPool(1);
        Callable<Object> call = new Callable<Object>() {
            public Object call() {
                try {
                    thread = Thread.currentThread();
                    return point.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                return null;
            }
        };
        Object result = null;
        Future<Object> future = exec.submit(call);
        try {
            result =  future.get(3, TimeUnit.SECONDS);
            logger.info("方法执行结果：{}",result);
        } catch (InterruptedException e) {
            logger.info("方法执行中断啦");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.info("方法执行异常啦");
            thread.interrupt();
        } catch (TimeoutException e) {
            logger.info("方法执行超时啦");
            thread.interrupt();
        }

        stopWatch.stop();
        logger.info("方法执行明细：{}",stopWatch.prettyPrint());
        logger.info("方法执行总耗时：{} s",stopWatch.getTotalTimeSeconds());
        return result;
    }
}