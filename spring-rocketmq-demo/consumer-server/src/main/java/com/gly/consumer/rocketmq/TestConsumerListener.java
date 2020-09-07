package com.gly.consumer.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消费者监听器
 **/
@Slf4j
@Component
// topic需要和生产者的topic一致，consumerGroup属性是必须指定的，内容可以随意
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "consumer-group",selectorExpression = "test-tag || hello-tag")
public class TestConsumerListener implements RocketMQListener<MessageExt> {

    /**
     * 监听到消息的时候就会调用该方法
     *
     * @param message 消息体
     */
    @Override
    public void onMessage(MessageExt message) {
        log.info("从test-topic中监听到消息");
        String tag = message.getTags();
        log.info("收到消息tag：{}",tag);
        String key = message.getKeys();
        log.info("收到消息key：{}",key);
        log.info(new String(message.getBody()));
    }
}

