package com.gly.nacos.feign;

import com.gly.nacos.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "nacos-discovery-provider",configuration = FeignConfig.class)
public interface EchoFeignClient {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable String string);
}
