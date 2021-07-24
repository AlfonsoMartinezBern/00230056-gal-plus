package com.telefonica.gal.client.dynamicrouting.td.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;

//@SpringBootTest
class DynamicRoutingTDClientTest {

	@Autowired
	DynamicRoutingTDClient drc;
	
	//@ParameterizedTest
	@CsvSource(value = {
			"OTT;CreateUser;http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management;OK",
			"OTT;CreateUser;http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management1;KO"
			}, delimiter = ';')
	
	void testDynamicRouting_Integration(String serviceId, String operationId, String uri, String result) {
		 RoutingTDInfo response = drc.search( new RoutingTDKey(serviceId, operationId, uri));
		 System.out.println( response.toString());
		assertEquals(result, response.getResult());
	}

}
