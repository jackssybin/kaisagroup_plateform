package com.kaisagroup.plateform.service.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class ZipkinTestAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinTestAApplication.class, args);
	}
}
