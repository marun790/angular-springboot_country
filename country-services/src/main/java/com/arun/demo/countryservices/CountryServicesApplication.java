package com.arun.demo.countryservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CountryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryServicesApplication.class, args);
	}

}
