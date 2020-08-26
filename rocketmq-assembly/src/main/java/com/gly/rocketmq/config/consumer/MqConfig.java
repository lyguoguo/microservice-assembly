package com.gly.rocketmq.config.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description:
 * @className: MqConfig
 * @package: com.yuntai.cons.config
 * @author: duanhr@hsyuntai.com
 * @date: 2020/3/18 9:18
 * @copyright: 版权归 HSYUNTAI 所有
 */
@Configuration
public class MqConfig {

    @Autowired
    private ConsumerConfig consumerConfig;

    @Resource
    private BaseListenerFactory baseListenerFactory;


    @Bean(value = "cfgConsumerFactory", initMethod = "init", destroyMethod = "destroy")
    public RocketMQPushConsumerFactoryBean hosNoticeConsumerFactory() {
        return new RocketMQPushConsumerFactoryBean(consumerConfig.getGroupName(),
                consumerConfig.getNamesrvAddr(),
                "cfg-notice-consumer",
                 baseListenerFactory,new HashMap<String,String>(){
            {
                put("TopicTest","Tag1");
                put("TopicTest1","Tag1");
            }
        });
    }

}
