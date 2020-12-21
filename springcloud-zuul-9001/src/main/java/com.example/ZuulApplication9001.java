package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Cursh
 */
@SpringBootApplication
@EnableZuulProxy  // zuul启动
public class ZuulApplication9001 {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication9001.class, args);
	}
}
