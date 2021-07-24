package com.telefonica.gal.client.dynamicrouting.td.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.gal.client.dynamicrouting.bu.facade.DynamicRoutingBUClient;
import com.telefonica.gal.client.dynamicrouting.bu.msg.RoutingBUInfo;
import com.telefonica.gal.client.dynamicrouting.bu.msg.RoutingBUKey;

@SpringBootTest
class DynamicRoutingTDClientTest {

	@Autowired
	DynamicRoutingBUClient drc;
	
	@ParameterizedTest
	@CsvSource(value = {
			"1;1;CreateUser;OK",
			"OTT;CreateUser;http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management1;KO"
			}, delimiter = ';')
	
	void testDynamicRouting_Integration(String instanceID, String platformID, String operationType, String result) {
		 RoutingBUInfo response = drc.search( new RoutingBUKey(instanceID, platformID, operationType));
		 System.out.println( response.toString());
		assertEquals(result, response.getResult());
	}

}
