//package com.gly.rocketmq.test;
//
//import com.gly.rocketmq.config.consumer.ConsumerConfigure;
//import lombok.extern.log4j.Log4j2;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.common.message.MessageAccessor;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.util.CollectionUtils;
//
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
//@Log4j2
//@Configuration
//public class TestConsumer extends ConsumerConfigure implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent arg0) {
//        try {
//            super.listener("TopicTest", "Tag1");
//        } catch (MQClientException e) {
//            log.error("消费者监听器启动失败", e);
//        }
//
//    }
//
//    @Override
//    public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs)  {
//        if (CollectionUtils.isEmpty(msgs)) {
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        }
//
//        MessageExt message = msgs.get(0);
//        try {
//            //逐条消费
//            String messageBody = new String(message.getBody(), RemotingHelper.DEFAULT_CHARSET);
//            System.err.println("Message Consumer: Handle New Message: messageId: " + message.getMsgId() + ",topic: " +
//                    message.getTopic() + ",tags: " + message.getTags() + ",messageBody: " + messageBody);
//
//            //模拟业务异常
////            int i = 1 / 0;
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        } catch (Exception e) {
//            log.error("Consume Message Error!!", e);
//            //抛出异常时，返回ConsumeConcurrentlyStatus.RECONSUME_LATER，尝试重试。当重试指定次数后返回ConsumeConcurrentlyStatus.CONSUME_SUCCESS
//            int reconsumeTimes = message.getReconsumeTimes();
//            System.err.println("Now Retry Times: " + reconsumeTimes);
//            if (reconsumeTimes >= 3) {
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//        }
//
//    }
//
//}
