package com.example.bootjpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootjpademoApplication {
	@Value("${server.port}")
	static String port;
	
	public static void main(String[] args) {
		System.out.println("starting application on port: " + port);
		SpringApplication.run(BootjpademoApplication.class, args);
	}

}
