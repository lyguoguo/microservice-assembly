package com.gly.hikari.dao;

import com.gly.hikari.entity.GatewayRoutes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (GatewayRoutes)表数据库访问层
 *
 * @author lvye.guo
 * @since 2020-05-28 09:43:30
 */
public interface GatewayRoutesDao {


    /**
     * 功能描述: <br> 根据主键ID启用/禁用

    /**
     * 功能描述: <br> 查询路由信息
     * 〈〉
     * @Param: [route]
     * @Return: java.util.List<com.yuntai.api.bean.GatewayRoutes>
     * @Author: lvye.guo
     * @Date: 2020/5/28 11:13
     */
    List<GatewayRoutes> getRoutes();

}