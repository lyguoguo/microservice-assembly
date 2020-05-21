package com.gly.rocketmq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class RocketmqTest extends RocketmqAssemblyApplicationTests {

    @Autowired
    private DefaultMQProducer producer;
    @Value("${rocket.delay.time.level}")
    private int delayTimeLevel;

    @Test
    public void producerTest() throws RemotingException, MQClientException, InterruptedException, IOException {
        String info = "我在做Rocketmq消息收发测试，这是第"+"1"+"条消息，当前时间秒数："+System.currentTimeMillis()/1000;
        Message message = new Message("TopicTest", "Tag1", "12345", info.getBytes());
        //设置延迟消息
        message.setDelayTimeLevel(delayTimeLevel);
        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
        //不过要注意的是这个是异步的
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
//                    log.info("传输成功");
//                    log.info(JSON.toJSONString(sendResult));
            }
            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
        log.info("消息发送完成");
//        System.in.read();
    }
}
