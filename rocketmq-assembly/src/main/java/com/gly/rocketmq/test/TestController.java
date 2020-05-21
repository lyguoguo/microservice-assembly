package com.gly.rocketmq.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Log4j2
public class TestController {

    @Autowired
    private DefaultMQProducer producer;
    @Value("${rocket.delay.time.level}")
    private int delayTimeLevel;

    /**
     * mq默认的：messageDelayLevel：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
     * @throws Exception
     */
    @GetMapping("/test1")
    public void test() throws Exception {
        log.info("接收到消息：{}",System.currentTimeMillis()/1000);
        String info = "我在做Rocketmq消息收发测试，这是第"+"1"+"条消息，当前时间秒数："+System.currentTimeMillis()/1000;
        Message message = new Message("TopicTest", "Tag1", "12345", info.getBytes());
        //设置延迟消息
//        message.setDelayTimeLevel(delayTimeLevel);
                // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
               //不过要注意的是这个是异步的
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSON.toJSONString(sendResult));
            }
            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }


    @GetMapping("/test2")
    public void nonDelayTest() throws Exception {
        log.info("接收到消息：{}",System.currentTimeMillis()/1000);
        String info = "我在做Rocketmq非延迟消息收发测试，这是第"+"2"+"条消息，当前时间秒数："+System.currentTimeMillis()/1000;
        Message message = new Message("TopicTest", "Tag2", "12345", info.getBytes());
        //设置延迟消息
//        message.setDelayTimeLevel(delayTimeLevel);
        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
        //不过要注意的是这个是异步的
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSON.toJSONString(sendResult));
            }
            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }
}