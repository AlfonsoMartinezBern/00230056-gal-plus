package com.telefonica.gal.enrutamientodinamico;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/conf")
public class ConfigController{
	
	static JSONObject conf;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ConfigController.class, args);
	}
	
	@PostMapping("/charge")
	public void chargeConf() {
		try {
			conf = ConfigService.chargeConf();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Servicio: " + conf.getJSONObject("example1").get("servicio"));
			System.out.println("EndPoint: " + conf.getJSONObject("example1").get("endpoint"));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/get/{nombre}")
	public String getEndpoint(@PathVariable String nombre) {
		return (String) conf.getJSONObject(nombre).get("endpoint");
	}
	
}
