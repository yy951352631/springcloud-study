package com.primeton.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker//对服务熔断的支持
@SpringBootApplication
@EnableEurekaClient
public class ServerMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerMainApplication.class, args);
	}
}
