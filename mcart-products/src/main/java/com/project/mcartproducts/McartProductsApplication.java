package com.project.mcartproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class McartProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartProductsApplication.class, args);
	}

}
