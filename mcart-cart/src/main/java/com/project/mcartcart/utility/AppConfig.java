package com.project.mcartcart.utility;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/* Master configuration file */
@Configuration
/* @Import annotation is used to import defined configuration files */
@Import(DatabaseConfig.class) 
/* If there are multiple configuration files then use like this @Import({ Module1Config.class, Module2Config.class }) */
/* To enable auto creation of service beans */
@ComponentScan(basePackages="com.project.mcartcart.service") 
public class AppConfig {
}

