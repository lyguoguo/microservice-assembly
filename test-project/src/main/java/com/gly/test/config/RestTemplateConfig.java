package com.gly.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: yt-med-pat-integrate
 * @Package: com.yuntai.pat.config
 * @ClassName: RestTemplateConfig
 * @Author: lvye.guo
 * @Description:
 * @Date: 2020/6/4 15:24
 * @Version: 1.0
 */
@Component
public class RestTemplateConfig {

    /**
     * 功能描述: <br>
     * 〈〉配置超时参数
     * @Param: []
     * @Return: org.springframework.web.client.RestTemplate
     * @Author: lvye.guo
     * @Date: 2020/6/4 15:25
     */
    @Bean
    public RestTemplate restTemplate() {
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectionRequestTimeout(restConfig.getConnectionRequestTimeout());
//        httpRequestFactory.setConnectTimeout(restConfig.getConnectTimeout());
//        httpRequestFactory.setReadTimeout(restConfig.getReadTimeout());
//        return new RestTemplate(httpRequestFactory);
        return new RestTemplate();
    }
}
