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

    @GetMapping("/test")
    public String test(){
//        String rawParam = readRaw(request.getInputStream());
//        JSONObject jsonObject = JSON.parseObject(rawParam);
//        HttpHeaders headers = new HttpHeaders();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = headerNames.nextElement();
//            String value = request.getHeader(key);
//            headers.add(key,value);
//        }
//        HttpEntity httpEntity = new HttpEntity<>(jsonObject, headers);
//        ResponseEntity resultResponseEntity = restTemplate.exchange(
//                remotePath,
//                method, httpEntity, Object.class);
//        if (resultResponseEntity.getStatusCode() == HttpStatus.OK) {
//            return resultResponseEntity.getBody();
//        }
        ResponseEntity resultResponseEntity = restTemplate.getForEntity("http://127.0.0.1:9090/hello/hello",String.class);
        if (resultResponseEntity.getStatusCode() == HttpStatus.OK) {
            return (String) resultResponseEntity.getBody();
        }
        return "ERROR REQUEST";
    }

}
