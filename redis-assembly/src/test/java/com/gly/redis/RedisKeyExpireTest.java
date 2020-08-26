package com.gly.redis;

import com.gly.redis.config.RedisOperator;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RedisKeyExpireTest extends BaseTest {
    @Autowired
    private RedisOperator redisOperator;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void getAndSet(){
        for(int i=0;i<5;i++){
            String oldKey = redisTemplate.opsForValue().getAndSet("ORDER_COUNT_1"+".lock","1");
            if("1".equals(oldKey)){
                System.out.println("old key 1"+oldKey);
                redisTemplate.expire("ORDER_COUNT_1"+".lock",5000, TimeUnit.SECONDS);
            }else{
                System.out.println("old key HAHA"+oldKey);
            }
        }

    }

    @Test
    public void insertExpireKey() throws InterruptedException {
//        redisOperator.set("test:order:N1234501","12.34",10);
//        redisOperator.set("test1:order:N1234501","12.34",13);
//        redisOperator.set("test2:order:N1234501","12.34",15);
        Date date = getEndOfDay(new Date());
//        System.out.println("今天最大时间："+ DateUtil.formatAsDatetime(date));
        //科室ID或医院ID
        redisTemplate.opsForValue().set("ORDER_COUNT_1","0");
        redisTemplate.expireAt("ORDER_COUNT_1",date);
        while (true){
            Thread.sleep(30*1000);
            redisTemplate.opsForValue().increment("ORDER_COUNT_1");
        }
    }

    /**
     *
     * @description: 获得当天最大时间
     * @author: Jeff
     * @date: 2019年12月21日
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()),
                ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
}
