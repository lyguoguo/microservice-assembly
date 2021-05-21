package com.example.msdb.db.service;

import com.example.msdb.db.entity.GatewayRoutes;

import java.util.List;

public interface GatewayRoutesService {
    List<GatewayRoutes> list();

    int update(GatewayRoutes gatewayRoutes);

    int insert(GatewayRoutes o);

    GatewayRoutes findById(long id);
}
