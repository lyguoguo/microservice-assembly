package com.gly.rest.template.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "spring.rest.template")
public class RestConfig {
    int connectionRequestTimeout;
    int connectTimeout;
    int readTimeout;
}
