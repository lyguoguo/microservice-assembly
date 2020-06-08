package com.gly.redis;

import com.gly.redis.config.RedisOperator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

public class RedisKeyExpireTest extends BaseTest {
    @Autowired
    private RedisOperator redisOperator;

    @Test
    public void insertExpireKey(){
        redisOperator.set("test:order:N1234501","12.34",10);
        redisOperator.set("test1:order:N1234501","12.34",13);
        redisOperator.set("test2:order:N1234501","12.34",15);
    }
}
