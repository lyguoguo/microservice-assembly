//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gly.rocketmq.config.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class RocketMQPushConsumerFactoryBean {
    private static final Logger logger = LoggerFactory.getLogger(RocketMQPushConsumerFactoryBean.class);
    private String consumerGroup;
    private String namesrvAddr;
    private String instanceName;
    private String topic;
    private String tags;
    private MessageListenerConcurrently messageListenerConcurrently;
    private DefaultMQPushConsumer consumer;
    private Map<String,String> map;

    public RocketMQPushConsumerFactoryBean(String consumerGroup, String namesrvAddr, String instanceName,MessageListenerConcurrently messageListener, Map<String,String> map) {
        this.consumerGroup = consumerGroup;
        this.namesrvAddr = namesrvAddr;
        this.instanceName = instanceName;
        this.messageListenerConcurrently = messageListener;
        this.map = map;
    }

    public void init() {
        logger.info("初始化 RocketMQ Consumer: group => {}, nameServer => {}, instanceName => {}, map => {}", new Object[]{this.consumerGroup, this.namesrvAddr, this.instanceName, this.map});
        this.consumer = new DefaultMQPushConsumer(this.consumerGroup);
        this.consumer.setNamesrvAddr(this.namesrvAddr);
        this.consumer.setInstanceName(this.instanceName);
        this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        this.consumer.registerMessageListener(this.messageListenerConcurrently);

        if(!CollectionUtils.isEmpty(map)){
            map.forEach((k,v)->{
                try {
                    this.consumer.subscribe(k, v);
                } catch (MQClientException var1) {
                    logger.error("初始化 RocketMQ Consumer subscribe 异常", var1);
                    throw new RuntimeException("无法初始化 RocketMQPushConsumerFactoryBean, 原因: Consumer 订阅异常");
                }
            });
        }
        try {
            this.consumer.start();
        } catch (MQClientException var2) {
            logger.error("初始化 RocketMQ Consumer start 异常", var2);
            throw new RuntimeException("无法初始化 RocketMQPushConsumerFactoryBean, 原因: 启动 Consumer 异常");
        }
    }

    public void destroy() {
        logger.info("执行 RocketMQ Consumer({}) 关闭", this.instanceName);
        this.consumer.shutdown();
        logger.info("关闭 RocketMQ Consumer({}) 完成.");
    }

    public DefaultMQPushConsumer getConsumer() {
        return this.consumer;
    }
}
