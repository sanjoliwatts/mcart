package com.project.mcartusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McartUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartUsersApplication.class, args);
	}

}
