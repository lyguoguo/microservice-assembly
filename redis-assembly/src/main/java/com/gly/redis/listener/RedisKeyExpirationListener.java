package com.gly.redis.listener;

import com.gly.redis.config.RedisOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    private final static Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);

    @Autowired
    private RedisOperator redisOperator;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
 
    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("接收到key过期监听：{}",message.getBody());
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        if(expiredKey.startsWith("test:order")){
            //TODO
            logger.info("key过期监听：{}",message.getBody());
        }
    }
}