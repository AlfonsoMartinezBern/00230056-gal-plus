package com.telefonica.gal.dinamicrouting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.gal.dinamicrouting.dto.RoutingTDInfo;
import com.telefonica.gal.dinamicrouting.model.DynamicRoutingTDRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DynamicRoutingControllerTest {

	@Autowired
	DynamicRoutingController dynamicRoutingController;
	
	@Autowired
	ConfigService confServ;


	@Test // OKAY
	public void testChargeDefaultConf() {
		assertEquals("OK", dynamicRoutingController.chargeConf().getResult());
	}

	@Test // OKAY
	public void testChargeValidConf() throws IOException {
		confServ.setConfigFile("/mapConfig/DynamicRoutingTD.json");
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // OKAY
	public void testAllJsonRequiredParameters() throws IOException {
		confServ.setConfigFile("/mapConfig/DynamicRoutingTD.json");
		RoutingTDInfo info = dynamicRoutingController.getJSON("OTT", "CreateUser",
				"http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // OKAY
	public void testAllJsonRequiredParameters_fail() throws IOException {
		confServ.setConfigFile("/mapConfig/DynamicRoutingTDfail.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("OTT", "CreateUser",
				"http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // TODO
	public void testIsValidConfigFile() {
		dynamicRoutingController.isValidConfigFile();
		fail("Not yet implemented");
	}

	@Test // TODO
	public void testGetLastChargeDate() {
		dynamicRoutingController.getLastChargeDate();
		fail("Not yet implemented");
	}

}
