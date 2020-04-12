package com.project.mcartcartdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McartCartDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartCartDetailsApplication.class, args);
	}

}
