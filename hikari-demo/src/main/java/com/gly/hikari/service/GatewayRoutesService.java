package com.gly.hikari.service;



import com.gly.hikari.entity.GatewayRoutes;

import java.util.List;

/**
 * (GatewayRoutes)表服务接口
 *
 * @author lvye.guo
 * @since 2020-05-28 09:43:30
 */
public interface GatewayRoutesService {


    /**
     * 功能描述: <br> 查询路由信息
     * 〈〉
     * @Param: [route]
     * @Return: java.util.List<com.yuntai.api.bean.GatewayRoutes>
     * @Author: lvye.guo
     * @Date: 2020/5/28 10:30
     */
    List<GatewayRoutes> getRoutes();

}