package com.example.msdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.example.msdb.db.dao")
@SpringBootApplication
@EnableAspectJAutoProxy
public class MsDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDbApplication.class, args);
    }

}
