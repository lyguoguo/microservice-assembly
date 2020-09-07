//package com.gly.consumer.rocketmq;
//
//import com.alibaba.fastjson.JSON;
//import com.gly.consumer.domain.MyMessage;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
///**
// * 消费者监听器
// **/
//@Slf4j
//@Component
//// topic需要和生产者的topic一致，consumerGroup属性是必须指定的，内容可以随意
//@RocketMQMessageListener(topic = "hello-topic", consumerGroup = "consumer-group")
//public class HelloConsumerListener implements RocketMQListener<MyMessage> {
//
//    /**
//     * 监听到消息的时候就会调用该方法
//     *
//     * @param message 消息体
//     */
//    @Override
//    public void onMessage(MyMessage message) {
//        log.info("从hello-topic中监听到消息");
//        log.info(JSON.toJSONString(message));
//    }
//}
//
