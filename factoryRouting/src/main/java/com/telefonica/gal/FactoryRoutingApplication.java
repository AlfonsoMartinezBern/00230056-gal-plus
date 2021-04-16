package com.telefonica.gal;

import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryRoutingApplication.class, args);
		FactoryRouting factoryRouting = new FactoryRouting();
		String url = "http://localhost:20100/GVP_TD_RegistrationService_2?wsdl";

		InvokeWs wsGvp = factoryRouting.getInvokeWs("GVP", "CreateUser", 2,
				2, url);
		wsGvp.invoke();

		System.out.println("Resultado ------> " + wsGvp);
	}

}
