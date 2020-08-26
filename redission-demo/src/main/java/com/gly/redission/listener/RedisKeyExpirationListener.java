package com.gly.redission.listener;

import com.gly.redission.config.RedisLock;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    private static final String  redisKey = "KEY:EXPIRE:";

    private final static Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);

    @Resource
    private RedisLock redisLock;
    @Resource
    private Environment environment;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
 
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        if(expiredKey.startsWith(redisKey)){
            logger.info("【key过期监听】接收到key过期监听：{} ",message.toString());
            boolean lock = redisLock.tryLock(String.format("redisson:lock:%s",expiredKey),TimeUnit.SECONDS,3,60);
            if(!lock){
                logger.info("服务：{}未获取到key：{}分布式锁，该key业务已被其他服务处理",environment.getProperty("server.port"),expiredKey);
                return;
            }
            //执行业务逻辑
            logger.info("key：{}已被服务：{}处理",expiredKey,environment.getProperty("server.port"));
        }
    }


}