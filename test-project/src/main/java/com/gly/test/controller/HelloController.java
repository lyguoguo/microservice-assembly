package com.gly.test.controller;

import com.gly.test.aspect.MyAnnotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger = LogManager.getLogger(HelloController.class);
    public static int time = 3;

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("time-task");

        final ExecutorService exec = Executors.newFixedThreadPool(1);
        Callable<Object> call = new Callable<Object>() {
            public Object call() throws Exception {
                 return process();
            }
        };
        Future<Object> future = exec.submit(call);
        try {
            Object result =  future.get(3*1000, TimeUnit.MILLISECONDS);
            System.out.println("方法执行结果："+result);
        } catch (InterruptedException e) {
            System.out.println("方法执行中断啦");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("方法执行异常啦");
            Thread.currentThread().interrupt();
        } catch (TimeoutException e) {
            System.out.println("方法执行超时啦");
            Thread.currentThread().stop();
        }

        stopWatch.stop();
        System.out.println("方法执行明细："+stopWatch.prettyPrint());
        System.out.println("方法执行总耗时："+stopWatch.getTotalTimeSeconds() + " s");
        return;
    }

    private static Object process() {
        try {
            System.out.println("方法执行开始");
            Thread.sleep(4*1000);
            System.out.println("方法执行结束");
            return "success";
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("方法执行中断");
            return "error";
        }

    }


    @Resource
    private Environment environment;

    @MyAnnotation
    @GetMapping("/timeout")
    public String timeout() throws InterruptedException {
        logger.info("开始执行timeout方法==============");
        logger.info("线程即将休眠=================");
        Thread.sleep(4*1000);
        logger.info("线程结束休眠=================");
        return "success";
    }

    @GetMapping("/timeout1")
    public String timeout1() throws InterruptedException {
        logger.info("开始执行timeout1方法==============");
        logger.info("线程即将休眠1=================");
        Thread.sleep(4*1000);
        logger.info("线程结束休眠1=================");
        return "success1";
    }


    @GetMapping("/hello")
    public String hello(HttpServletRequest request,int id,String name){
        logger.info("接收到来自远程主机：{}的请求：{} {}",request.getRemoteHost(),request.getRequestURL(),request.getHeader("traceId"));
        logger.info("当前主机端口信息：{}",environment.getProperty("server.port"));
//        try {
//            Thread.sleep(3*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        RestTemplate restTemplate = new RestTemplate();
        try {
            String result = restTemplate.getForObject(new URI("http://127.0.0.1:8172/test"),String.class);
            logger.info("远程调用返回result：{}",request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        logger.info("当前请求traceId：{}",request.getHeader("traceId"));
        logger.info("请求处理完成");
        return "Hello World";
    }

    @PostMapping("/test")
    public String test(String id,int num){
        return "success";
    }



}
