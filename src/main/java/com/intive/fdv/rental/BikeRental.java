package com.intive.fdv.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.intive.fdv.rental.*" })
public class BikeRental {

	public static void main(String[] args) {
		SpringApplication.run(BikeRental.class, args);
	}

}
