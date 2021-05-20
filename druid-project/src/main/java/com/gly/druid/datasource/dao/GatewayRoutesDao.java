package com.gly.druid.datasource.dao;

import com.gly.druid.datasource.entity.GatewayRoutes;
import org.apache.ibatis.annotations.Param;

public interface GatewayRoutesDao {
    GatewayRoutes getByRouteId(@Param("routeId") String routeId);
}
