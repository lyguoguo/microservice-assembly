package com.gly.producer;

import com.gly.producer.rocketmq.Source;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({Source.class})
@SpringBootApplication
public class StreamRocketmqProducerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamRocketmqProducerServerApplication.class, args);
    }

}
