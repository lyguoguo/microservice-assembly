package com.gly.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RefreshScope
public class ApplicationConfig {

    @Value("${open.config:false}")
    private boolean openConfig;
    @Value("${rocketmq.consumer.tag:test}")
    private String rocketmqConsumerTag;
    @Value("${push.prefix:alarm}")
    private String pushPrefix;

    public boolean isOpenConfig() {
        return openConfig;
    }

    public void setOpenConfig(boolean openConfig) {
        this.openConfig = openConfig;
    }

    public String getRocketmqConsumerTag() {
        return rocketmqConsumerTag;
    }

    public void setRocketmqConsumerTag(String rocketmqConsumerTag) {
        this.rocketmqConsumerTag = rocketmqConsumerTag;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" + "openConfig=" + openConfig + ", rocketmqConsumerTag='" + rocketmqConsumerTag
                + '\'' + ", pushPrefix=" + pushPrefix
                + '}';
    }

    public String getPushPrefix() {
        return pushPrefix;
    }

    public void setPushPrefix(String pushPrefix) {
        this.pushPrefix = pushPrefix;
    }
}
