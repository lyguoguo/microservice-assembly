//package com.gly.rocketmq.config.consumer;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Component
//public class ToBePayRpConsumer {
//
//    /** 日志对象 */
//    private static final Logger logger = LogManager.getLogger(ToBePayRpConsumer.class);
//
//    @Value("${rocketmq.consumer.groupName}")
//    private String consumerGroup;
//
//    @Value("${rocketmq.consumer.namesrvAddr}")
//    private String namesrvAddr;
//
//    @Value("TopicTest1")
//    private String topic;
//
//    @Value("Tag1")
//    private String tags;
//
//    @PostConstruct
//    public void defaultMQPushConsumer() {
//
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
//        consumer.setNamesrvAddr(namesrvAddr);
//
//        try {
//            consumer.subscribe(topic, tags);
//
//            //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
//            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//            consumer.registerMessageListener(new MessageListenerConcurrently() {
//                @Override
//                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                    MessageExt message = msgs.get(0);
//                    logger.info("ToBePayRpConsumer Message Consumer: Handle New Message: messageId: {} ,topic: {} ,tags: {} ,messageBody: {}",
//                            message.getMsgId() ,
//                            message.getTopic() ,
//                            message.getTags(),
//                            message);
//                	//YzMqBean yzMqBean = null;
//                    for (MessageExt msg : msgs) {
//                    }
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//            });
//            consumer.start();
//        } catch (Exception e) {
//            logger.error("服务异常 ",e);
//        }
//    }
//
//
//}
