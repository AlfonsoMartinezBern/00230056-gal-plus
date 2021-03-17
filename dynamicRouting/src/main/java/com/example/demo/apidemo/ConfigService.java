package com.example.demo.apidemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

public class ConfigService {

	static JSONObject conf;

	@SuppressWarnings("resource")
	public static JSONObject chargeConf() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader(new File("C:/Develop/Repositorio/00230056-gal-plus/dynamicRouting/src/main/resources/mapConfig/DynamicRoutingTD.json")));
		String linea, json = "";
		while ((linea = reader.readLine()) != null) {
			json = json + linea;
		}
		return new JSONObject(json);
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<JSONObject> chargeConfArray() throws IOException {
		ArrayList<JSONObject> jsons = new ArrayList<>();
		BufferedReader reader = new BufferedReader(
				new FileReader(new File("C:/Develop/Repositorio/00230056-gal-plus/dynamicRouting/src/main/resources/mapConfig/DynamicRoutingTD.json")));
		String linea, json = "";
		while ((linea = reader.readLine()) != null) {
			json = json + linea;
		}
		Iterator<Object> jsonarray = new JSONObject(json).getJSONArray("dynamicRoutingTD").iterator();
		
		while (jsonarray.hasNext()) {
//			System.out.println(jsonarray.next());
			jsons.add((JSONObject) jsonarray.next());
		}
		
		return jsons;
	}
}
