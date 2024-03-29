
package com.capg.fms.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//Author                : Capgemini
//Created/Modified Date : 20/08/2020
//Description			: Main Application

@SpringBootApplication
//@EnableEurekaClient
@EnableSwagger2
public class FmsAirportMsApplication {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("")).build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FmsAirportMsApplication.class, args);
	}
}
