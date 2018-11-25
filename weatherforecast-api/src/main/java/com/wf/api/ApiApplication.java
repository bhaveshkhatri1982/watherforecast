package com.wf.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 * this module which consists of rest services can also run without web module.
 */
@Configuration
@ComponentScan(basePackages="com.wf.*")
@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories
public class ApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }
}
