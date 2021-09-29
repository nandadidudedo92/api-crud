package com.example.juniorprogrammer.apicrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApicrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicrudApplication.class, args);
	}

}
