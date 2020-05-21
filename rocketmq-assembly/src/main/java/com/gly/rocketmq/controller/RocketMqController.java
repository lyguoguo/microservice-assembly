package com.gly.rocketmq.controller;

import com.gly.rocketmq.config.RocketMQProducer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description：
 */
@RestController
public class RocketMqController {

    @Autowired
    @Qualifier("rocketMQProducer")
    RocketMQProducer rocketMQProducer;

    @GetMapping("/test1")
    public void TestSend1() {
        DefaultMQProducer producer = rocketMQProducer.getRocketMQProducer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String body = "【TAG1】hi RocketMQ, now is  " + sdf.format(new Date()) + ".";
        Message message = new Message("topic2020", "test1", body.getBytes());
        try {
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/test2")
    public void TestSend2() {
        DefaultMQProducer producer = rocketMQProducer.getRocketMQProducer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String body = "【TAG2】hi RocketMQ, now is  " + sdf.format(new Date()) + ".";
        Message message = new Message("topic2020", "test2", body.getBytes());
        try {
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}