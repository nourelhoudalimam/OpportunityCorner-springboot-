package com.example.stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages="com.example.stage")
public class OpportunityCorner1Application {

	public static void main(String[] args) {
		SpringApplication.run(OpportunityCorner1Application.class, args);
	}

}
