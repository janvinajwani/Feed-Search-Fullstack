package com.feedProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.feedProject")
public class FeedProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedProjectApplication.class, args);
	}

}