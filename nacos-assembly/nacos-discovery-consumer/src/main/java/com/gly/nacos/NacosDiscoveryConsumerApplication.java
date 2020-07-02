package com.gly.nacos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.gly.nacos.feign")
@EnableDiscoveryClient
public class NacosDiscoveryConsumerApplication {

    private static Logger logger = LogManager.getLogger(NacosDiscoveryConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConsumerApplication.class, args);
        logger.info("=============nacos-discovery-consumer初始化完成================");
    }

}
