package com.gly.log4j2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LogManager.getLogger(TestController.class);

    @GetMapping("/test")
    public String test(int id) {
        logger.info("开始测试日志打印信息,请求参数 id-> {} ==============", id);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            logger.error("日志打印发生异常：{}", e);
        }
        logger.info("日志打印测试完成===================");
        return "success";
    }

}
