package com.project.mcartcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McartCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartCartApplication.class, args);
	}

}
