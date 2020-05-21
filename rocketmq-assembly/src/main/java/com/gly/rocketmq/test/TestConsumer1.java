package com.gly.rocketmq.test;

import com.gly.rocketmq.config.consumer.ConsumerConfigure;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
@Configuration
public class TestConsumer1 extends ConsumerConfigure implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
        MessageExt message = msgs.get(0);
        String messageBody = null;
        try {
            messageBody = new String(message.getBody(), RemotingHelper.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("【我是一号TAG】Message Consumer: Handle New Message: messageId: " + message.getMsgId() + ",topic: " +
                message.getTopic() + ",tags: " + message.getTags() + ",messageBody: " + messageBody);
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }

    @Override
    public String getTag() {
        return "Tag1";
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("nothing to update");
    }
}
