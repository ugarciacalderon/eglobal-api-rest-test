package com.eglobal.api_rest_eglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.eglobal.api_rest_eglobal.repository")
public class ApiRestEglobalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestEglobalApplication.class, args);
	}

}
