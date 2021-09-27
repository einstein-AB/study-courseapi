package com.springboot.courseapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class CourseApiApplication {

	Logger logger = LoggerFactory.getLogger(CourseApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApplication.class, args);
	}

	/*Configuring what is considered for API documentation in swagger*/
	//@Bean
	public Docket swaggerConfiguration() {
		logger.info("Configuring swagger from main app");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/topics/**")) //URLs starting with this patterns
				.apis(RequestHandlerSelectors.basePackage("com.springboot.courseapi")) //scan only this package for documentation inclusion
				.build();
	}

}
