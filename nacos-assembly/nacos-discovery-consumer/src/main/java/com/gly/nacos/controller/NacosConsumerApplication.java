package com.gly.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosConsumerApplication {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-discovery-provider/echo/"+str,String.class);
    }
}
