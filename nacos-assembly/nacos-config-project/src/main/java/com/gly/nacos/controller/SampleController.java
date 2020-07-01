package com.gly.nacos.controller;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.fastjson.JSON;
import com.gly.nacos.config.ApplicationConfig;
import com.gly.nacos.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SampleController {

	@Resource
	UserConfig userConfig;

	@Resource
	private ApplicationConfig applicationConfig;

	@Resource
	private NacosConfigManager nacosConfigManager;

	@Value("${user.name}")
	String userName;

	@Value("${user.age:25}")
	Integer age;

	@RequestMapping("/user")
	public String simple() {
		return "Hello Nacos Config!" + "Hello " + userName + " " + age + " [UserConfig]: "
				+ userConfig + "!" + nacosConfigManager.getConfigService();
	}

	@RequestMapping("/bool")
	public boolean bool() {
		return (Boolean) (userConfig.getMap().get("2"));
	}

	@RequestMapping("/config")
	public String config(){
		return applicationConfig.toString();
	}

}