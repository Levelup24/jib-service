package com.levelup.jib;

import client.JibClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = JibClient.class)
public class JibApplication {

	public static void main(String[] args) {
		SpringApplication.run(JibApplication.class, args);
	}

}
