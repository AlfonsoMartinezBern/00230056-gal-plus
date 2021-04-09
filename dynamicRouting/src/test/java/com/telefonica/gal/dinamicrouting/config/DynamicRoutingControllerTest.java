package com.telefonica.gal.dinamicrouting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
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
	
	@Test // 001
	public void testChargeDefaultConf() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_001.json").getAbsolutePath());
		assertEquals("OK", dynamicRoutingController.chargeConf().getResult());
	}

	@Test // 002
	public void testChargeDefaultConf_fail() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_002.json").getAbsolutePath());
		assertEquals("KO", dynamicRoutingController.chargeConf().getResult());
	}

	@Test // 003
	public void testChargeValidConf() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_003.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 004
	public void testChargeValidConf_fail() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_004.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 005
	public void testAllJsonRequiredParameters() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_005.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 006
	public void testAllJsonRequiredParameters_failIdOnEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_006.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 007
	public void testAllJsonRequiredParameters_failInstanceIdOnEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_007.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 008
	public void testAllJsonRequiredParameters_failPlatformIdOnEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_008.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 009
	public void testAllJsonRequiredParameters_failTargetEndpoint() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_009.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 010
	public void testAllJsonRequiredParameters_failAlterFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_010.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 011
	public void testAllJsonRequiredParameters_failEndpointType() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_011.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 012
	public void testAllJsonRequiredParameters_failStep() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_012.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 013
	public void testAllJsonRequiredParameters_failEndpointIdOnFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_013.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 014
	public void testAllJsonRequiredParameters_failTypeOnFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_014.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 015
	public void testAllJsonRequiredParameters_failActive() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_015.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 016
	public void testAllJsonRequiredParameters_failFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_016.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 017
	public void testAllJsonRequiredParameters_2endpoints_failFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_017.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 018
	public void testAllJsonRequiredParameters_2endpoints() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_018.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 019
	public void testAllJsonRequiredParameters_2endpoints_repeatFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_019.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 020
	public void testAllJsonRequiredParameters_2endpoints_failFlows() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_020.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 021
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_021.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 022
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow_2() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_022.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isTrue();
	}

	@Test // 023
	public void testAllJsonRequiredParameters_2endpoints_failOneFlow_3() throws IOException {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_023.json").getAbsolutePath());
		DynamicRoutingTDRepository repo = confServ.getDynamicRoutingTDFromJson();
		assertThat(repo.isValid(repo.getRoutes())).isFalse();
	}

	@Test // 024
	public void testGetJson() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_024.json").getAbsolutePath());
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test024",
				"testGetJson", "http://telefonica.com/test024");
		assertEquals("OK", info.getResult());
	}

	@Test // 025
	public void testGetJson_failParameters() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_025.json").getAbsolutePath());
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON("Test024",
				"testGetJson_fail", "http://telefonica.com/test024");
		assertEquals("KO", info.getResult());
	}

	@Test // 026
	public void testGetJson_nullParameters() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_026.json").getAbsolutePath());
		dynamicRoutingController.configService = confServ;
		RoutingTDInfo info = dynamicRoutingController.getJSON(null,
				null, null);
		assertEquals("KO", info.getResult());
	}

	@Test // 027
	public void testGetLastChargeDate() {
		confServ.setConfigFile(new File("src/test/resources/DynamicRoutingTDtest_027.json").getAbsolutePath());
		assertEquals("OK", dynamicRoutingController.getLastChargeDate().getResult());
	}

	@Test // 028
	public void testGetLastChargeDate_fail() throws IOException {
		DynamicRoutingController dynamicRoutingFail = new DynamicRoutingController();
		assertEquals("KO", dynamicRoutingFail.isValidConfigFile().getResult());
	}

}
