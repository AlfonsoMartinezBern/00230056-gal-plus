package com.telefonica.gal.SPAIN_TD_CustomerProvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.telefonica.gal.client.spain" , "com.telefonica.gal.SPAIN_TD_CustomerProvision" ,
								"com.telefonica.gal", "com.telefonica.gal.client.spain.td",
								"com.telefonica.gal.client.spain.td.error.facade"})

public class SpainTdCustomerProvisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpainTdCustomerProvisionApplication.class, args);
	}

}

