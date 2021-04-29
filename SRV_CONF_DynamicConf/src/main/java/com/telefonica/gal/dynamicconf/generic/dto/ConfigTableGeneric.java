package com.telefonica.gal.dynamicconf.generic.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.joda.time.DateTime;

import com.telefonica.gal.dynamicconf.utils.Formatter;

public class ConfigTableGeneric<K, V> implements ConfTable<K, V> {

	protected HashMap<String, V> mapTable = new HashMap<>();
	private String lastUpload;
	private String configFileVersion;
	private String configFileInfo;
	private String dynamicFileName;
	
	
	
	
    public ConfigTableGeneric(String dynamicRoutingName) {
		super();
		this.dynamicFileName = dynamicRoutingName;
	}

	@Override
	public void add(K key, V value) {
		mapTable.put(key.toString(), value);
		
	}
    

    
    public V search(K key) {
    	V search = mapTable.get(key.toString());
		return search;
	}
    
	
	@Override
	public String getConfTableInfo() {
		return isCharge()
				? "The "+dynamicFileName+" file vesion:" + this.configFileVersion + ", info:" + this.configFileInfo
						+ ", was uploaded on " + this.lastUpload
				: "The DynamicRouting file is not loaded";
	}
	

	@Override
	public boolean isCharge() {
		return configFileVersion != null;
	}

	public void setLastConfigurationTimeStamp(DateTime chargeDateTime) {
		this.lastUpload = Formatter.getDateTime(chargeDateTime);
	}

	public void setConfigFileVersion(String configFileVersion) {
		this.configFileVersion = configFileVersion;
	}

	public void setConfigFileInfo(String info) {
		this.configFileInfo = info;

	}

	@Override
	public ArrayList<V> search() {
		 Collection<V> values = mapTable.values();		 
		return new ArrayList<>(values);
	}

}
