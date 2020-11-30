package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 访问地址 :http://localhost:7001/
@SpringBootApplication
@EnableEurekaServer  //服务端的启动类
public class EurekaServer7003Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003Application.class, args);
    }
}
