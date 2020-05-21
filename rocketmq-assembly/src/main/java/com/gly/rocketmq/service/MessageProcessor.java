package com.gly.rocketmq.service;

import org.apache.rocketmq.common.message.MessageExt;

public interface MessageProcessor {

    boolean handle(MessageExt messageExt);

}