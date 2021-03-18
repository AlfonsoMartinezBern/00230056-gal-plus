package com.example.demo.apidemo;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/conf")
public class ConfigController {

	static ArrayList<JSONObject> conf;

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ConfigController.class, args);
		conf = ConfigService.chargeConfArray();
	}

	@GetMapping("/charge")
	public String chargeConf() {
		try {
			conf = ConfigService.chargeConfArray();
			return "Configuración cargada";
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@GetMapping("/getEndpoint/{nombre}")
	public String getEndpoint(@PathVariable String nombre) {
		JSONArray endpoint = null;
		for (JSONObject json : conf) {
			if (json.getString("serviceID").equals(nombre)) {
				endpoint = (JSONArray) json.get("endpoints");
			}
		}
		return endpoint.toString();
	}

	@GetMapping("/getService/{nombre}")
	public String getService(@PathVariable String nombre) {
		String service = "";
		for (JSONObject json : conf) {
			if (json.getString("operationTD").equals(nombre)) {
				service = json.getString("serviceID");
			}
		}
		return service;
	}

	@GetMapping("/search")
	public String getJSON(@RequestBody DynamicRoutingDTO dto) {
		try {
			for (JSONObject json : conf) {
				if (json.getString("serviceID").equals(dto.getServiceID())
						&& json.getString("operationTD").equals(dto.getOperationTD())
						&& json.getString("uri").equals(dto.getUri())) {
					return json.toString();
				}
			}
			return "{\"Error\" : \"No se ha encontrado el servicio\"}";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/list")
	public String listJSON() {
		try {
			return conf.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
