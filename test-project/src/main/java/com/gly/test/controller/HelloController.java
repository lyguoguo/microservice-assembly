package com.gly.test.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger = LogManager.getLogger(HelloController.class);

    @Resource
    private Environment environment;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        logger.info("接收到来自远程主机：{}的请求：{} {}",request.getRemoteHost(),request.getRequestURL(),request.getHeader("traceId"));
        logger.info("当前主机端口信息：{}",environment.getProperty("server.port"));
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("请求处理完成");
        return "Hello World";
    }


}
