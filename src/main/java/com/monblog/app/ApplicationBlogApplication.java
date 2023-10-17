package com.monblog.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
info = @Info(
		title = "Mon Blog Application",
		description ="Spring boot Application",
		version ="v1.0",
		contact =@Contact (name="Jules MESSOLO", email="messjule@msn.com")
				))
public class ApplicationBlogApplication {

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBlogApplication.class, args);
	}

}
