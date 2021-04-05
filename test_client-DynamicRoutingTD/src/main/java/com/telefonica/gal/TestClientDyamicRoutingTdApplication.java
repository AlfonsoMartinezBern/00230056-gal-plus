package com.telefonica.gal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;

@SpringBootApplication
public class TestClientDyamicRoutingTdApplication implements ApplicationRunner{

	@Autowired
	DynamicRoutingTDClient drTDClient;
	
	public static void main(String[] args) {
		SpringApplication.run(TestClientDyamicRoutingTdApplication.class, args);
		
	}
	
	public void run(ApplicationArguments arg0) throws Exception {

		System.out.println("Test DynamicRoutingTDClient");
		System.out.println();
		RoutingTDKey tdKey = new RoutingTDKey("NotValue", "", "");
		RoutingTDInfo response = drTDClient.search(tdKey);
		
		System.out.println(response);
		System.out.println();
		System.out.println(drTDClient.search(new RoutingTDKey("OTT", "CreateUser", "http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management")));
	   }

}
