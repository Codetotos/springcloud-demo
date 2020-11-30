package com.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
//    配置负载均衡实现RestTemplate
    @Bean
    @LoadBalanced  //Ribbon配置
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
