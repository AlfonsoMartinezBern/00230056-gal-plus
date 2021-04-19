package com.telefonica.gal;

import com.telefonica.gal.factory.FactoryRouting;
import com.telefonica.gal.wsRouting.InvokeWs;
import org.springframework.boot.SpringApplication;


public class FactoryRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryRoutingApplication.class, args);
		FactoryRouting factoryRouting = new FactoryRouting();
		String url = "http://localhost:20100/GVP_TD_RegistrationService_2?wsdl";

		/*InvokeWs wsGvp = factoryRouting.getInvokeWs("GVP", "CreateUser", 2,
				2, url);
		wsGvp.invoke();

		System.out.println("Resultado ------> " + wsGvp);*/
	}

}
