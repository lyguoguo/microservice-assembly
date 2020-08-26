package com.gly.rest.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Enumeration;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testforrest")
    public String test(){
        ResponseEntity resultResponseEntity = restTemplate.getForEntity("http://47.114.140.237:9090/hello/hello",String.class);
        if (resultResponseEntity.getStatusCode() == HttpStatus.OK) {
            return (String) resultResponseEntity.getBody();
        }
        return "ERROR REQUEST";
    }

}
