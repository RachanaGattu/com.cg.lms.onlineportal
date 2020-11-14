package com.cg.lms.onlineportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Online Survey Module Started....");
		SpringApplication.run(Application.class, args);
	}

}
