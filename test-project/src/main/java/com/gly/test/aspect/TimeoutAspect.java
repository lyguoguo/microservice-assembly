//package com.gly.test.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;
//
//import java.util.concurrent.*;
//
///**
// * @ClassName: LogAspect
// * @Description: @Loggable 注解日志切面
// * 注解示例: @Loggable(bizDec = "【模块名称】-【接口名称】", level = Level.info, printResult = true)
// */
//@Component
//@Aspect
//public class TimeoutAspect {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutAspect.class);
//
//    /**
//     * 切面表达式
//     */
//    private final String executeExpr = "execution(* com.gly.test..*Controller.*(..))";
//
//    /**
//     * 切面表达式,统一打印Controller方法的日志
//     * @param point
//     * @return
//     * @throws Throwable
//     */
//    @Around("@annotation(log)")
//    public Object aroundExecution(ProceedingJoinPoint point) throws Throwable {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start("time-task");
//
//        final ExecutorService exec = Executors.newFixedThreadPool(1);
//        Callable<Object> call = new Callable<Object>() {
//            public Object call() {
//                try {
//                    return  point.proceed();
//                } catch (Throwable throwable) {
//                    throwable.printStackTrace();
//                }
//                return null;
//            }
//        };
//        Object result = null;
//        Future<Object> future = exec.submit(call);
//        try {
//            result =  future.get(3*1000, TimeUnit.MILLISECONDS);
//            System.out.println("方法执行结果："+result);
//        } catch (InterruptedException e) {
//            System.out.println("方法执行中断啦");
//            Thread.currentThread().interrupt();
//        } catch (ExecutionException e) {
//            System.out.println("方法执行异常啦");
//            Thread.currentThread().interrupt();
//        } catch (TimeoutException e) {
//            System.out.println("方法执行超时啦");
//            Thread.currentThread().stop();
//        }
//
//        stopWatch.stop();
//        System.out.println("方法执行明细："+stopWatch.prettyPrint());
//        System.out.println("方法执行总耗时："+stopWatch.getTotalTimeSeconds() + " s");
//        return result;
//    }
//
//
//}
