//package com.gly.consumer.rocketmq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.stereotype.Component;
//
//@Component
//public  class ConsumerCustomRunner implements CommandLineRunner {
//
//		@Autowired
//		private Sink sink;
//
//		@Override
//		public void run(String... args) throws InterruptedException {
//			while (true) {
//				sink.input5().poll(m -> {
//					String payload = (String) m.getPayload();
//					System.out.println("pull msg: " + payload);
//				}, new ParameterizedTypeReference<String>() {
//				});
//				Thread.sleep(2_000);
//			}
//		}
//
//	}