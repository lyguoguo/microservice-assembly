package com.gly.nacos;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class NacosConfigProjectApplication {

    private static Logger logger = LogManager.getLogger(NacosConfigProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigProjectApplication.class, args);
        logger.info("=================nacos-config-project服务初始化完成==================");
    }

}
