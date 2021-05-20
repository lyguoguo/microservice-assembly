package com.gly.hikari.service.impl;

import com.gly.hikari.dao.GatewayRoutesDao;
import com.gly.hikari.entity.GatewayRoutes;
import com.gly.hikari.service.GatewayRoutesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * (GatewayRoutes)表服务实现类
 *
 * @author lvye.guo
 * @since 2020-05-28 09:43:30
 */
@Service
public class GatewayRoutesServiceImpl implements GatewayRoutesService {

    private static final Logger logger = LogManager.getLogger(GatewayRoutesServiceImpl.class);

    @Resource
    private GatewayRoutesDao gatewayRoutesDao;


   /**
    * 功能描述: <br> 查询路由信息
    * 〈〉
    * @Param: [route]
    * @Return: java.util.List<com.yuntai.api.bean.GatewayRoutes>
    * @Author: lvye.guo
    * @Date: 2020/5/28 11:10
    */
    @Override
    public List<GatewayRoutes> getRoutes() {
        return gatewayRoutesDao.getRoutes();
    }


}