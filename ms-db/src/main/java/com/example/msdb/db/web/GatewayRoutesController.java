package com.example.msdb.db.web;


import com.example.msdb.db.entity.GatewayRoutes;
import com.example.msdb.db.service.GatewayRoutesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GatewayRoutesController {

    @Resource
    private GatewayRoutesService gatewayRoutesService;

    @GetMapping("/route/list")
    public List<GatewayRoutes> list(){
        return gatewayRoutesService.list();
    }

    @GetMapping("/route/update")
    public int update(GatewayRoutes gatewayRoutes){
        return gatewayRoutesService.update(gatewayRoutes);
    }


}
