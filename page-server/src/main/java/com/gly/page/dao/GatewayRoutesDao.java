package com.gly.page.dao;

import com.gly.page.model.GatewayRoutes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GatewayRoutesDao {
    int deleteByPrimaryKey(Long id);

    int insert(GatewayRoutes record);

    int insertSelective(GatewayRoutes record);

    GatewayRoutes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GatewayRoutes record);

    int updateByPrimaryKey(GatewayRoutes record);

    List<GatewayRoutes> selectAll();
}