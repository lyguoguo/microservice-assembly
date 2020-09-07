package com.gly.event.service;

import com.gly.event.event.OrderSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class SmsService {

    /**
     * 发送短信 @EventListener指定监听的事件
     */
    @Order(2)
    @EventListener(OrderSuccessEvent.class)
    @Async
    public void sendSms() {
        System.out.println("发送短信...");
    }

}
