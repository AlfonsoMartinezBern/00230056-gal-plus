package com.example.demo.apidemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

public class ConfigService {
	
	static JSONObject conf;
	
	@SuppressWarnings("resource")
	public static JSONObject chargeConf() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Develop/STSWorkspace/demo/directory/conf.json")));
		String linea, json = "";
		while ((linea = reader.readLine()) != null ) {
			json = json + linea;
		}
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		System.out.println("Servicio: " + conf.getJSONObject("example1").get("servicio"));
//		System.out.println("EndPoint: " + conf.getJSONObject("example1").get("endpoint"));
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		return new JSONObject(json);
	}
}
