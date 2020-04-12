package com.project.mcartconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class McartConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartConfigServerApplication.class, args);
	}

}
