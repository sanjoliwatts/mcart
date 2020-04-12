package com.project.mcarteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class McartEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartEurekaApplication.class, args);
	}

}
