package com.gly.rocketmq.factory;

import org.apache.rocketmq.common.message.MessageExt;

public interface MessageProcessor {

    boolean handle(MessageExt messageExt);

}