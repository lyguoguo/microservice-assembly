package com.gly.nacos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("user")
@RefreshScope
public class UserConfig {
    private int age;
    private String name;
    private Map<String, Object> map;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "UserConfig{" + "age=" + age + ", name='" + name + '\'' + ", map=" + map
                + '}';
    }
}
