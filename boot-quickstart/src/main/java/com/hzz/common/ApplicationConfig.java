package com.hzz.common;

import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 还可以指定独立文件: ConfigurationProperties(locations="classpath:/myInfo.properties",prefix = "my")
 * 将前缀为'app.message'的properties属性注入到相应的变量上
 */
@ConfigurationProperties(prefix = "app.message", ignoreInvalidFields = true)
public class ApplicationConfig {
    private String name;
    private String version;
    private String hello;
    private List<String> servers = Lists.newArrayList();

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
