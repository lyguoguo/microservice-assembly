//package com.gly.event.event;
//
//import org.springframework.context.ApplicationListener;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Service;
//
///**
// * 短信服务，监听OrderSuccessEvent
// */
//@Service
//@EnableAsync
//public class SmsService implements ApplicationListener<OrderSuccessEvent> {
//
//    @Override
//    @Async
//    public void onApplicationEvent(OrderSuccessEvent event) {
//        this.sendSms();
//    }
//
//    /**
//     * 发送短信
//     */
//    public void sendSms() {
//        System.out.println("发送短信...");
//    }
//}
