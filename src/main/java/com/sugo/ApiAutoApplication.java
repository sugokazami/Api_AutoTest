package com.sugo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sugo","org.n3r.idworker"})
public class ApiAutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAutoApplication.class, args);
	}
}
