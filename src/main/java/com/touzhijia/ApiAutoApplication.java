package com.touzhijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.touzhijia","org.n3r.idworker"})
public class ApiAutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAutoApplication.class, args);
	}
}
