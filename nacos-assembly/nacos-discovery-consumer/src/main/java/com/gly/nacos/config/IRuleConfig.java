package com.gly.nacos.config;

import com.gly.nacos.ribbon.NacosWeightRandomV2Rule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IRuleConfig {

    @Bean
    IRule rule(){
        return new NacosWeightRandomV2Rule();
    }

}
