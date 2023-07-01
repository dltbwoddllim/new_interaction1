package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.restapi")
public class RestapiApplication {
	public static void main(String[] args) {

		SpringApplication.run(RestapiApplication.class, args);
	}

}
