package com.gly.druid.datasource.service;

import com.gly.druid.datasource.entity.GatewayRoutes;

public interface GatewayRoutesService {

    GatewayRoutes getByRouteId(String routeId);
}
