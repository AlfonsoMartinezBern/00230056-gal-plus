package com.telefonica.gal.enrutamientodinamico;

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
		
		return new JSONObject(json);
	}
}
