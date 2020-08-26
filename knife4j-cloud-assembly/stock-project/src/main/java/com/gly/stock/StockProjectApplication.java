package com.gly.stock;

import com.github.xiaoymin.knife4j.discovery.annotation.EnableKnife4jCloudDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableKnife4jCloudDiscovery
@SpringBootApplication
public class StockProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockProjectApplication.class, args);
    }

}
