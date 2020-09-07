package com.gly.producer.rocketmq;

import com.alibaba.fastjson.JSON;
import com.gly.producer.domain.MyMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 生产者
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class TestProducerController {

    /**
     * 用于发送消息到 RocketMQ 的api
     */
    private final RocketMQTemplate rocketMQTemplate;

    @GetMapping("/test-rocketmq/sendMsg")
    public String testSendMsg(String tag) {
        log.info("消息发送时间：{}", DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
        String topic = "test-topic";
        Message message = MessageBuilder.withPayload(JSON.toJSONString(MyMessage.getInstance())).
                setHeader("KEYS", System.currentTimeMillis()).build();
        rocketMQTemplate.asyncSend(topic + ":" +tag, message,new SendCallback(){

            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("消息发送成功，当前时间：{}",DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("消息发送失败，当前时间：{}",DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
            }
        },10,3);
        return "send message success";
    }
}
