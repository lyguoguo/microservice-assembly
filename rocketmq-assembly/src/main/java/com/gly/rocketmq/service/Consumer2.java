package com.gly.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer2 {
    public boolean handle(MessageExt messageExt) {
        // 收到的body（消息体），字节类型，需转为String
        String result = new String(messageExt.getBody());
        log.error("【Consumer2】监听到了消息{}，重试次数为：{}，消息为：{}",messageExt.getMsgId(),messageExt.getReconsumeTimes(), result);
        return false;
    }
}
