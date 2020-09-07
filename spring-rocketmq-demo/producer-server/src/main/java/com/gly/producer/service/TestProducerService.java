package com.gly.producer.service;

import com.gly.producer.domain.MyMessage;
import com.zj.node.contentcenter.dao.content.NoticeMapper;
import com.zj.node.contentcenter.dao.log.RocketmqTransactionLogMapper;
import com.zj.node.contentcenter.domain.entity.content.Notice;
import com.zj.node.contentcenter.domain.entity.log.RocketmqTransactionLog;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestProducerService {

    private final RocketMQTemplate rocketMQTemplate;

    public String testSendMsg(MyMessage myMessage) {
        // topic
        String topic = "test-topic";
        // 生产者所在的事务组
        String txProducerGroup = "tx-test-producer-group";
        // 生产事务id
        String transactionId = UUID.randomUUID().toString();
        // 发送半消息
        rocketMQTemplate.sendMessageInTransaction(
                txProducerGroup, topic,
                // 消息体
                MessageBuilder.withPayload("事务消息")
                        // header是消息的头部分，可以用作传参
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                        .setHeader("notice_id", myMessage.getId())
                        .build(),
                // 传递到executeLocalTransaction的参数
                myMessage);

        return "send message success";
    }

}