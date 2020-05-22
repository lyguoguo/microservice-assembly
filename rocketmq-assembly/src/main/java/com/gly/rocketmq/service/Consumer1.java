package com.gly.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer1{
    public boolean handle(MessageExt messageExt) {
        // 收到的body（消息体），字节类型，需转为String
        try{
            String result = new String(messageExt.getBody());
            log.info("【Consumer1】监听到了消息{}，消息为：{}",messageExt.getMsgId(), result);
            int i = 1/0;
            return true;
        }catch (Exception e){
            /**
             * 限制单个消息最大重试次数为3次，超过该次数默认为消费成功，则此消息将从队列中移除
             */
            if(messageExt.getReconsumeTimes() >= 3){
                log.error("消息：{}重试次数：{} 次，已达到最大级别；",messageExt.getMsgId(),messageExt.getReconsumeTimes());
                return true;
            }
            return false;
        }
    }
}
