package com.telefonica.gal.dinamicrouting;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.gal.dinamicrouting.dto.MessageResponse;
import com.telefonica.gal.dinamicrouting.dto.RoutingTDInfo;
import com.telefonica.gal.dinamicrouting.dto.RoutingTDKey;
import com.telefonica.gal.dinamicrouting.dto.RoutingTableTD;

@SpringBootApplication
@RestController
@RequestMapping("/dinamicRoutingTD")

public class DynamicRoutingController {

	@Autowired
	ConfigService configService;

	@Autowired
	RoutingTableTD routingTable;

	private boolean isCharged = false;

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(DynamicRoutingController.class, args);
	}

	@PutMapping("/charge")
	public MessageResponse chargeConf() {

		isCharged = configService.chargeConf();

		if (isCharged)
			return new MessageResponse("OK", routingTable.getRoutingTableInfo());
		else
			return new MessageResponse("KO", "RoutingTDConfigFile update failed");

	}

//	@GetMapping("/search")
//	public RoutingTDInfo getJSON(@RequestBody RoutingTDKey dtoIN) {
//			isCharged();
//			return routingTable.search(dtoIN);
//	}

	@GetMapping("/search")
	public RoutingTDInfo getJSON(@RequestParam String serviceID, @RequestParam String operationTD,
			@RequestParam String uri) {
		isCharged();
		RoutingTDKey key = new RoutingTDKey(serviceID, operationTD, uri);
		return routingTable.search(key);
	}

	@GetMapping("/getInfo")
	public MessageResponse isValidConfigFile() {
		if (routingTable == null)
			return new MessageResponse("KO", "No se ha cargado la configuración del fichero");
		return new MessageResponse(routingTable.isCharge() ? "OK" : "KO", routingTable.getRoutingTableInfo());
	}

	@GetMapping("/isValidConfigFile")
	public MessageResponse getLastChargeDate() {
		return configService.isValidChargeConf() ? new MessageResponse("OK", "The RoutingTDConfigFile is valid")
				: new MessageResponse("KO", "The RoutingTDConfigFile is NOT valid");
	}

	private void isCharged() {
		if (!isCharged) {
			isCharged = configService.chargeConf();
		}
	}

}