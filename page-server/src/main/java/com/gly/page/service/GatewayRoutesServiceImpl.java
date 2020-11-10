package com.gly.page.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gly.page.dao.GatewayRoutesDao;
import com.gly.page.model.GatewayRoutes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GatewayRoutesServiceImpl implements GatewayRoutesService{

    @Resource
    private GatewayRoutesDao gatewayRoutesDao;

    @Override
    public PageInfo<GatewayRoutes> pageList(int page,int size) {
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(page, size);
        List<GatewayRoutes> gatewayRoutes = gatewayRoutesDao.selectAll();
        // 封装分页之后的数据  返回给客户端展示  PageInfo做了一些封装 作为一个类
        PageInfo<GatewayRoutes> pageGatewayRoutes = new PageInfo<>(gatewayRoutes);

        return pageGatewayRoutes;

    }
}
