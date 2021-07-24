package com.telefonica.gal.dynamicconf.generic.dto;

import java.util.ArrayList;

import org.joda.time.DateTime;

public interface ConfTable<K,V> {
	
	public V search(K key);
	public ArrayList<V> search();
	
	public void add(K key, V value);

	public String getConfTableInfo();
	public boolean isCharge();
	
	void setLastConfigurationTimeStamp(DateTime chargeDateTime);
	void setConfigFileVersion(String configFileVersion);
	void setConfigFileInfo(String info);
	

}
