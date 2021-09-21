package com.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}


//	@Bean
//	public OpenAPI customOpenAPI(){
//		return new OpenAPI().info(new Info().title("Cloud Parking").version("1.0")
//				.termsOfService("http://swagger.io/terms")
//				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
//	}

}
