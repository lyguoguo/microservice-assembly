package com.gly.page;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gly.page.dao")
@SpringBootApplication
public class PageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageServerApplication.class, args);
    }

}
