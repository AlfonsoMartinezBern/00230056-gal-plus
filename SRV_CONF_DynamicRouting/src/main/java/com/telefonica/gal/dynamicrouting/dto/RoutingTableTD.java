package com.telefonica.gal.dynamicrouting.dto;

import java.util.HashMap;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicrouting.utils.Formatter;

@Component
public class RoutingTableTD {
	
	private HashMap<String,RoutingTDInfo> routingTable = new HashMap<>();
	private String lastUpload;
	private String configFileVersion;
	private String configFileInfo;
	
	public void add(String key, RoutingTDInfo value) {
		routingTable.put(key, value);
		
	}
	
	public RoutingTDInfo search(RoutingTDKey key) {
		String prueba = key.toString();
		RoutingTDInfo response = routingTable.get(key.toString());
		//System.out.println("RESPONSE:"+response);
		return response==null || response.getEndpoints().isEmpty()? new RoutingTDInfo(null, null):response;
	}


	public void setLastConfigurationTimeStamp(DateTime chargeDateTime) {
		this.lastUpload = Formatter.getDateTime(chargeDateTime);
	}


	public void setConfigFileVersion(String configFileVersion) {
		this.configFileVersion = configFileVersion;
	}
	
	public String getRoutingTableInfo() {
		return isCharge()
				?"The DynamicRouting file vesion:"+this.configFileVersion+", info:"+this.configFileInfo+", was uploaded on "+ this.lastUpload
				:"The DynamicRouting file is not loaded" ;
	}
	
	public boolean isCharge() {
		return configFileVersion!=null;
	}

	public void setConfigFileInfo(String info) {
		this.configFileInfo = info;
		
	}
	


}
