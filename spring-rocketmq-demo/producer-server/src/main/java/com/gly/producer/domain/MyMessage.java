package com.gly.producer.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MyMessage {
    private Integer id;
    private String name;
    private String status;
    private Date createTime;

    public static MyMessage getInstance() {
        MyMessage message = new MyMessage();
        message.id = 1;
        message.name = "×××";
        message.status = "default";
        message.createTime = new Date();

        return message;
    }
}
