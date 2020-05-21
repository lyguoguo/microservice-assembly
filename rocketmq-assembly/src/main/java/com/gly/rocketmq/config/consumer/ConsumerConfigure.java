package com.gly.rocketmq.config.consumer;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Log4j2
public abstract class ConsumerConfigure {

    @Autowired
    private ConsumerConfig consumerConfig;

    // 开启消费者监听服务
    public void listener() throws MQClientException {
        log.info(consumerConfig.toString());

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerConfig.getGroupName());

        consumer.setNamesrvAddr(consumerConfig.getNamesrvAddr());

        consumer.subscribe("TopicTest", "*");

        // 开启内部类实现监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                log.info("接收到消息============");
                return ConsumerConfigure.this.dealBody(list);
            }
        });

        consumer.start();

        log.info("rocketmq启动成功---------------------------------------");

    }
    
    // 处理body的业务
    public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);

    public abstract String getTag();

}