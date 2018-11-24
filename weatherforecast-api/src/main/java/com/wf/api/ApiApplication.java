package com.wf.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

/**
 * this module which consists of rest services can also run without web module.
 * https://github.com/mokarakaya/spring-boot-multi-module-maven
 */
@Configuration
@ComponentScan(basePackages="com.wf.api.*")
@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class ApiApplication{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiApplication.class, args);
	}
}
