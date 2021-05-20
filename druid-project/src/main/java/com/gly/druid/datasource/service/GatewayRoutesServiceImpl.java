package com.gly.druid.datasource.service;

import com.gly.druid.datasource.dao.GatewayRoutesDao;
import com.gly.druid.datasource.entity.GatewayRoutes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GatewayRoutesServiceImpl implements GatewayRoutesService{

    @Resource
    private GatewayRoutesDao gatewayRoutesDao;

    @Override
    public GatewayRoutes getByRouteId(String routeId) {
        return gatewayRoutesDao.getByRouteId(routeId);
    }
}
