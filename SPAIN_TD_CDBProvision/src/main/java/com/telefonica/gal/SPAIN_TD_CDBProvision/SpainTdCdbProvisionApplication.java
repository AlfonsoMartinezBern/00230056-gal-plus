package com.telefonica.gal.SPAIN_TD_CDBProvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.telefonica.gal.client.spain", "com.telefonica.gal"})
public class SpainTdCdbProvisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpainTdCdbProvisionApplication.class, args);
	}

}
