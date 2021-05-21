package com.example.msdb;

import com.example.msdb.db.entity.GatewayRoutes;
import com.example.msdb.db.service.GatewayRoutesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
//@Transactional //测试完成回滚数据
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MsDbApplication.class)
public class DemoServiceTest {

    @Autowired
    public GatewayRoutesService service;

    @Test
    public void CRUDTest() {

        //CREATE
        GatewayRoutes o = new GatewayRoutes();
        o.setId(99990008l);
        o.setRouteId("test-demo");
        o.setCreateTime(new Date());
        o.setRouteUri("lb://test-demo");
        o.setCreateTime(new Date());

        int i = service.insert(o);
        System.out.println("结果："+i);
        Assert.assertNotNull(i);

//        //READ
        o = service.findById(99990008l);
        Assert.assertNotNull(o);
        System.out.println("结果："+o.getRouteUri());

//        //UPDATE
//        o.setTitle("CRUDTest1");
//        service.save(o);
//        o = service.findById(o.getId());
//        Assert.assertTrue(o.getTitle().equals("CRUDTest1"));
//
//        //DELETE
//        service.delete(o.getId());
//        o = service.findById(o.getId());
//        Assert.assertNull(o);

    }

}