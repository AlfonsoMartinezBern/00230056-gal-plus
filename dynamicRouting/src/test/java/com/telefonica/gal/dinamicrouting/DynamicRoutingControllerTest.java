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


	@Test // 028
	public void testGetLastChargeDate_fail() throws IOException {
		assertEquals("KO", dynamicRoutingController.isValidConfigFile().getResult());
	}
	
	@Test // 001
	public void testChargeDefaultConf() {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_001.json");
		assertEquals("OK", dynamicRoutingController.chargeConf().getResult());
	}

	@Test // 002
	public void testChargeDefaultConf_fail() {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_002.json");
		assertEquals("KO", dynamicRoutingController.chargeConf().getResult());
	}

	@Test // 003
	public void testChargeValidConf() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_003.json");
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 004
	public void testChargeValidConf_fail() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_004.json");
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 005
	public void testAllJsonRequiredParameters() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_005.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test005", "testAllJsonRequiredParameters",
				"http://telefonica.com/test005");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 006
	public void testAllJsonRequiredParameters_failIdOnEndpoint() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_006.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test006",
				"testAllJsonRequiredParameters_failIdOnEndpoint", "http://telefonica.com/test006");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 007
	public void testAllJsonRequiredParameters_failInstanceIdOnEndpoint() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_007.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test007",
				"testAllJsonRequiredParameters_failInstanceIdOnEndpoint", "http://telefonica.com/test007");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 008
	public void testAllJsonRequiredParameters_failPlatformIdOnEndpoint() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_008.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test008",
				"testAllJsonRequiredParameters_failPlatformIdOnEndpoint", "http://telefonica.com/test008");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 009
	public void testAllJsonRequiredParameters_failTargetEndpoint() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_009.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test009",
				"testAllJsonRequiredParameters_failTargetEndpoint", "http://telefonica.com/test009");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 010
	public void testAllJsonRequiredParameters_failAlterFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_010.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test010", "testAllJsonRequiredParameters_failAlterFlow",
				"http://telefonica.com/test010");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 011
	public void testAllJsonRequiredParameters_failEndpointType() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_011.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test011",
				"testAllJsonRequiredParameters_failEndpoitnType", "http://telefonica.com/test011");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 012
	public void testAllJsonRequiredParameters_failStep() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_012.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test012", "testAllJsonRequiredParameters_failStep",
				"http://telefonica.com/test012");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 013
	public void testAllJsonRequiredParameters_failEndpointIdOnFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_013.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test013",
				"testAllJsonRequiredParameters_failEndpointIdOnFlow", "http://telefonica.com/test013");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 014
	public void testAllJsonRequiredParameters_failTypeOnFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_014.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test014", "testAllJsonRequiredParameters_failTypeOnFlow",
				"http://telefonica.com/test014");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 015
	public void testAllJsonRequiredParameters_failActive() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_015.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test015", "testAllJsonRequiredParameters_failActive",
				"http://telefonica.com/test015");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 016
	public void testAllJsonRequiredParameters_failFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_016.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test016", "testAllJsonRequiredParameters_failFlow",
				"http://telefonica.com/test016");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 017
	public void testAllJsonRequiredParameters_2endpoints_failFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_017.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test017",
				"testAllJsonRequiredParameters_2endpoints_failFlow", "http://telefonica.com/test017");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 018
	public void testAllJsonRequiredParameters_2endpoints() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_018.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test018", "testAllJsonRequiredParameters_2endpoints",
				"http://telefonica.com/test018");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 019
	public void testAllJsonRequiredParameters_2endpoints_repeatFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_019.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test019",
				"testAllJsonRequiredParameters_2endpoints_repeatFlow", "http://telefonica.com/test019");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 020
	public void testAllJsonRequiredParameters_2endpoints_failFlows() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_020.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test020",
				"testAllJsonRequiredParameters_2endpoints_failFlows", "http://telefonica.com/test020");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 021
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_021.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test021",
				"testAllJsonRequiredParameters_2endpoints_failOneFlow", "http://telefonica.com/test021");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 022
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow_2() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_022.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test022",
				"testAllJsonRequiredParameters_2endpoints_failOneFlow_2", "http://telefonica.com/test022");
		assertEquals(true, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 023
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow_3() throws IOException {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_023.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test023",
				"testAllJsonRequiredParameters_2endpoints_failOneFlow_3", "http://telefonica.com/test023");
		assertEquals(false, confServ.isAllRequiredParameters(info.getEndpoints(), info.getFlows()));
	}

	@Test // 024
	public void testGetJson() {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_024.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test024",
				"testGetJson", "http://telefonica.com/test024");
		assertEquals("OK", info.getResult());
	}

	@Test // 025
	public void testGetJson_failParameters() {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_025.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test024",
				"testGetJson_fail", "http://telefonica.com/test024");
		assertEquals("KO", info.getResult());
	}

	@Test // 026
	public void testGetJson_nullParameters() {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_026.json");
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON(null,
				null, null);
		assertEquals("KO", info.getResult());
	}

	@Test // 027
	public void testGetLastChargeDate() {
		confServ.setConfigFile("/mapConfig/test/DynamicRoutingTDtest_027.json");
		assertEquals("OK", dynamicRoutingController.getLastChargeDate().getResult());
	}

//	@Test // 028
//	public void testGetLastChargeDate_fail() throws IOException {
//		DynamicRoutingController failChargedDateController = new DynamicRoutingController();
//		failChargedDateController.configService = new ConfigService("/mapConfig/test", "DynamicRoutingTDtest_028.json");
//		assertEquals("KO", new DynamicRoutingController().getLastChargeDate().getResult());
//	}

}