package com.example.sharding.web;

import com.example.sharding.entity.Order;
import com.example.sharding.entity.TConfig;
import com.example.sharding.mapper.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController {
    @Autowired
    private ConfigDao configDao;

    @RequestMapping(value = "/listConfig", method = RequestMethod.GET)
    public List<TConfig> getConfig() {
        return this.configDao.findAll();
    }

    @RequestMapping(value = "/config/save", method = RequestMethod.POST)
    public TConfig saveOrder(@RequestParam("config") String config, @RequestParam("userid") Long userId) {
        TConfig tConfig = new TConfig();
        tConfig.setConfig(config);
        tConfig.setUserId(userId);
        return this.configDao.save(tConfig);
    }
}
