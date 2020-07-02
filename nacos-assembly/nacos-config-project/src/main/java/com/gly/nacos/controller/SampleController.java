package com.gly.nacos.controller;

import com.gly.nacos.config.ApplicationConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SampleController {

	@Resource
	private ApplicationConfig applicationConfig;

	@RequestMapping("/config")
	public String config(){
		return applicationConfig.toString();
	}

}