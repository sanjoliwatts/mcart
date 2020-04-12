package com.project.mcartorderdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McartOrderDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartOrderDetailsApplication.class, args);
	}

}
