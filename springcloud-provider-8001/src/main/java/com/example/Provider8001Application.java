package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //自动注册到eureka
@EnableDiscoveryClient // 服务发现
public class Provider8001Application {
	public static void main(String[] args) {
		SpringApplication.run(Provider8001Application.class, args);
	}
}
