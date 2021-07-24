package com.telefonica.gal.dynamicrouting;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicRoutingTD {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(DynamicRoutingTD.class, args);
	}
}
