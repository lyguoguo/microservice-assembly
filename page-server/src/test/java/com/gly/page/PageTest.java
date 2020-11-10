package com.gly.page;

import com.github.pagehelper.PageInfo;
import com.gly.page.model.GatewayRoutes;
import com.gly.page.service.GatewayRoutesService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class PageTest extends PageServerApplicationTests {

    @Resource
    private GatewayRoutesService gatewayRoutesService;

    @Test
    public void test(){
        PageInfo<GatewayRoutes> pageInfo = gatewayRoutesService.pageList(1,10);
        Assert.assertNotNull(pageInfo);
        pageInfo.getList().forEach(gatewayRoutes -> {
            System.out.println(gatewayRoutes.toString());
        });
    }
}
