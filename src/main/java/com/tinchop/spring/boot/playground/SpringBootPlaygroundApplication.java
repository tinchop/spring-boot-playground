package com.tinchop.spring.boot.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}

}
