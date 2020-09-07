//package com.gly.event.event;
//
//import org.springframework.context.ApplicationListener;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Service;
//
///**
// * 物流服务
// */
//@Service
//@EnableAsync
//public class CarService  implements ApplicationListener<OrderSuccessEvent> {
//    @Override
//    @Async
//    public void onApplicationEvent(OrderSuccessEvent event) {
//        this.dispatch();
//    }
//
//    public void dispatch() {
//        System.out.println("发车咯...");
//    }
//}
