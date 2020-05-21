package com.gly.rocketmq.config.producer;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class ProducerConfigure {

    @Autowired
    private ProducerConfig producerConfigure;

    /**
     * 创建普通消息发送者实例
     * 
     * @return
     * @throws
     */
    @Bean
    /**
     * //prefix为配置文件中的前缀,
     * 	//name为配置的名字
     * 	//havingValue是与配置的值对比值,当两个值相同返回true,配置类生效.
     */
//    @ConditionalOnProperty(prefix = "rocketmq.producer", value = "default", havingValue = "true")
    public DefaultMQProducer defaultProducer() throws MQClientException {
        log.info(producerConfigure.toString());
        log.info("defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(producerConfigure.getGroupName());
        producer.setNamesrvAddr(producerConfigure.getNamesrvAddr());
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendAsyncFailed(producerConfigure.getRetryTimes());
        producer.setRetryTimesWhenSendFailed(producerConfigure.getRetryTimes());
        producer.start();
        log.info("rocketmq producer server开启成功---------------------------------.");
        return producer;
    }
}