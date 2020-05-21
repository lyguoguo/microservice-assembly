package com.gly.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description：监听消息处理类
 */
@Slf4j
@Service
public class MessageProcessorImpl implements MessageProcessor {

    @Autowired
    private Consumer1 consumer1;
    @Autowired
    private Consumer2 consumer2;

    @Override
    public boolean handle(MessageExt messageExt) {
       String tag = messageExt.getTags();
       if("test1".equals(tag)){
           return consumer1.handle(messageExt);
       }
       if("test2".equals(tag)){
           return consumer2.handle(messageExt);
       }
       log.info("未知类型的消息");
       return true;
    }
}