package com.gly.producer.domain;

import lombok.Data;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

@Data
public class MyMessage extends Message {
    private Integer id;
    private String name;
    private String status;
    private Date createTime;
}
