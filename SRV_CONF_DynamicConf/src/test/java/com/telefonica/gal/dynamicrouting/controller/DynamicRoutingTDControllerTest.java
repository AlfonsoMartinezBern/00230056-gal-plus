package com.telefonica.gal.dynamicrouting.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.unica.td.dto.ConfingInfo_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.facade.DynamicRouting_UNICA_TD_Facade;

@RunWith(SpringRunner.class)
@SpringBootTest
class DynamicRoutingTDControllerTest {

	@Autowired
	DynamicRouting_UNICA_TD_Facade dynamicRoutingFacade;

	@Autowired
	ConfigService confServ;

	@Test // 001
	public void testChargeDefaultConf() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_001.json").getAbsolutePath());
		assertEquals("OK", dynamicRoutingFacade.chargeConf().getResult());
	}

	@Test // 002
	public void testChargeDefaultConf_fail() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_002.json").getAbsolutePath());
		assertEquals("KO", dynamicRoutingFacade.chargeConf().getResult());
	}

	@Test // 003
	public void testChargeValidConf() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_003.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 004
	public void testChargeValidConf_fail() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_004.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 005
	public void testAllJsonRequiredParameters() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_005.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 006
	public void testAllJsonRequiredParameters_failIdOnEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_006.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 007
	public void testAllJsonRequiredParameters_failInstanceIdOnEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_007.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 008
	public void testAllJsonRequiredParameters_failPlatformIdOnEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_008.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 009
	public void testAllJsonRequiredParameters_failTargetEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_009.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 010
	public void testAllJsonRequiredParameters_failAlterFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_010.json").getAbsolutePath());

		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 011
	public void testAllJsonRequiredParameters_failEndpointType() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_011.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 012
	public void testAllJsonRequiredParameters_failStep() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_012.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 013
	public void testAllJsonRequiredParameters_failEndpointIdOnFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_013.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 014
	public void testAllJsonRequiredParameters_failTypeOnFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_014.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 015
	public void testAllJsonRequiredParameters_failActive() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_015.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 016
	public void testAllJsonRequiredParameters_failFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_016.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 017
	public void testAllJsonRequiredParameters_2endpoints_failFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_017.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 018
	public void testAllJsonRequiredParameters_2endpoints() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_018.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 019
	public void testAllJsonRequiredParameters_2endpoints_repeatFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_019.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 020
	public void testAllJsonRequiredParameters_2endpoints_failFlows() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_020.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 021
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_021.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 022
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow_2() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_022.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isTrue();
	}

	@Test // 023
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow_3() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_023.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}

	@Test // 024
	public void testGetJson() {
		dynamicRoutingFacade.getConfigService()
				.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_024.json").getAbsolutePath());
		ConfingInfo_UNICA_TD info = dynamicRoutingFacade.getJSON("Test024", "testGetJson",
				"http://telefonica.com/test024");
		assertEquals("OK", info.getResult());
	}

	@Test // 025
	public void testGetJson_failParameters() {
		dynamicRoutingFacade.getConfigService()
		.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_025.json").getAbsolutePath());
		ConfingInfo_UNICA_TD info = dynamicRoutingFacade.getJSON("Test024", "testGetJson_fail",
				"http://telefonica.com/test024");
		assertEquals("KO", info.getResult());
	}

	@Test // 026
	public void testGetJson_nullParameters() {
		dynamicRoutingFacade.getConfigService()
		.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_026.json").getAbsolutePath());
		ConfingInfo_UNICA_TD info = dynamicRoutingFacade.getJSON(null, null, null);
		assertEquals("KO", info.getResult());
	}

	@Test // 027
	public void testGetLastChargeDate() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_027.json").getAbsolutePath());
		assertEquals("OK", dynamicRoutingFacade.getConfigInfo().getResult());
	}

	@Test // 028
	public void testGetLastChargeDate_fail() throws IOException {
		DynamicRouting_UNICA_TD_Facade dynamicRoutingFail = new DynamicRouting_UNICA_TD_Facade(null, null);
		assertEquals("KO", dynamicRoutingFail.isValidConfigFile().getResult());
	}

	@Test // 029
	public void testAllJsonRequiredParameters_duplicateIdOnEndpoints() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_029.json").getAbsolutePath());
		assertThat(confServ.chargeConf()).isFalse();
	}
	
}
