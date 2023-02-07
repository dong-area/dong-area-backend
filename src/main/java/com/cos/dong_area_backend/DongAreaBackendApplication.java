package com.cos.dong_area_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DongAreaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DongAreaBackendApplication.class, args);
	}

}
