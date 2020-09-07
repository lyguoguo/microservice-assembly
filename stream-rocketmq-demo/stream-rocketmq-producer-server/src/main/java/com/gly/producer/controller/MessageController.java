package com.gly.producer.controller;

import com.gly.producer.rocketmq.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private SenderService senderService;

    @GetMapping("/send")
    public String sendMessage(){
        try {
            senderService.sendWithTags("我在测试output1的消息","out1");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("消息发送失败：",e);
            return "fail";
        }
        return "success";
    }

}
