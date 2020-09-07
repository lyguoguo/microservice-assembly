package com.gly.consumer;

import com.gly.consumer.rocketmq.Sink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({Sink.class})
@SpringBootApplication
public class StreamRocketmqConsumerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamRocketmqConsumerServerApplication.class, args);
    }

}
