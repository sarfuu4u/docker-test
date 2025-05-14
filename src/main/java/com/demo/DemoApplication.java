package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.service.StudentService;

// From this class project execution will begin
// Default Configuration Class

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
//	@Bean
//	public StudentService getStudentObject() {
//		return new StudentService();
//	}
	// We can also use @Bean here it also work but it is bad practice
}
