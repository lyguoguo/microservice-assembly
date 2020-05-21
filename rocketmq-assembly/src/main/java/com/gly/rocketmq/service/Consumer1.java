package com.gly.rocketmq.service;

import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

@Service
public class Consumer1{
    public boolean handle(MessageExt messageExt) {
        // 收到的body（消息体），字节类型，需转为String
        String result = new String(messageExt.getBody());
        System.out.println("【Consumer1】监听到了消息，消息为："+ result);
        return true;
    }
}
