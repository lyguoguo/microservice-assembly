package com.gly.multi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: microservice-assembly
 * @Package: com.gly.multi.config
 * @ClassName: DingTalkConfig
 * @Author: lvye.guo
 * @Description: 钉钉机器人配置类
 * @Date: 2020/6/9 15:51
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "ding.talk")
public class DingTalkConfig {
    private String postUrl;
}
