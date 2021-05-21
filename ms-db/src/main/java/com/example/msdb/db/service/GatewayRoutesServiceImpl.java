package com.example.msdb.db.service;

import com.example.msdb.datasource.annotation.Master;
import com.example.msdb.datasource.annotation.Slave;
import com.example.msdb.db.dao.GatewayRoutesMapper;
import com.example.msdb.db.entity.GatewayRoutes;
import com.example.msdb.db.entity.GatewayRoutesExample;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GatewayRoutesServiceImpl implements GatewayRoutesService{

    @Resource
    private GatewayRoutesMapper gatewayRoutesMapper;

    @Override
    public List<GatewayRoutes> list() {
        GatewayRoutesExample example = new GatewayRoutesExample();
        GatewayRoutesExample.Criteria criteria = example.createCriteria();
        criteria.andRouteIdLike("%yt-med-cfg-server%");
        return gatewayRoutesMapper.selectByExample(example);
    }

    @Override
    public int update(GatewayRoutes gatewayRoutes) {
        return gatewayRoutesMapper.updateByPrimaryKeySelective(gatewayRoutes);
    }

    @Slave
    @Override
    public int insert(GatewayRoutes gatewayRoutes) {
        return gatewayRoutesMapper.insertSelective(gatewayRoutes);
    }

//    @Slave
//    @Master
    @Override
    public GatewayRoutes findById(long id) {
        GatewayRoutesExample example = new GatewayRoutesExample();
        GatewayRoutesExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<GatewayRoutes> routes =  gatewayRoutesMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(routes)){
            return null;
        }else {
            return routes.get(0);
        }
    }
}
