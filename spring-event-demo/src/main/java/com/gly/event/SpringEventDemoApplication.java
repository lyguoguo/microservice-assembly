package com.gly.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class SpringEventDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEventDemoApplication.class, args);
    }

}
