package com.hzz;

import com.hzz.common.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 如果想部署到tomcat等容器中,需要继承SpringBootServletInitializer
 * EnableConfigurationProperties配置properties属性注入ApplicationConfig
 */
@SpringBootApplication
@EnableConfigurationProperties(value = ApplicationConfig.class)
public class QuickstartApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuickstartApplication.class, args);
    }
}
