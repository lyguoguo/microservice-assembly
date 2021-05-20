package com.gly.druid.datasource.controller;

import com.gly.druid.datasource.service.GatewayRoutesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GatewayRoutesController {

    private Logger logger = LoggerFactory.getLogger(GatewayRoutesController.class);

    @Resource
    private GatewayRoutesService gatewayRoutesService;

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<String> getByRouteId(@PathVariable("routeId") String routeId){
        for(;;){
            try {
                gatewayRoutesService.getByRouteId(routeId+(int) Math.floor(Math.random() * 5+1));
//                Thread.sleep(((int) Math.floor(Math.random() * 3+1))*10*1000);
                Thread.sleep(15*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
