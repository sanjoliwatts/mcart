package com.project.mcartzipkin;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class McartZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(McartZipkinApplication.class, args);
	}

}
