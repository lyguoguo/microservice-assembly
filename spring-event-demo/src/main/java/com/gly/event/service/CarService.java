package com.gly.event.service;

import com.gly.event.event.OrderSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * 物流服务
 */
@Service
@EnableAsync
public class CarService{

    @EventListener(OrderSuccessEvent.class)
    @Order(1)
    @Async
    public void dispatch() {
        System.out.println("发车咯...");
    }
}
