package com.gly.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.gly.druid.datasource.dao"})
public class DruidProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(DruidProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DruidProjectApplication.class, args);
        log.info("========================服务启动成功======================");
    }

}
