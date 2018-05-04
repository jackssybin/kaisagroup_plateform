package com.kaisagroup.plateform.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfClientApplication.class, args);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("foot from env: " + env.getProperty("foot"));
	}


}
