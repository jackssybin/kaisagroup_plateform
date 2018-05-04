package com.kaisagroup.plateform.service.base.zipkin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 */
@SpringBootApplication
@EnableZipkinStreamServer
@EnableDiscoveryClient
public class SleuthServerApplicaton {

	public static void main(String[] args) {
		SpringApplication.run(SleuthServerApplicaton.class, args);
	}

}
