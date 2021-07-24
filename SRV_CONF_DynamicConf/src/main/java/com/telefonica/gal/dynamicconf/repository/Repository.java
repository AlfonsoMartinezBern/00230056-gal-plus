package com.telefonica.gal.dynamicconf.repository;

import java.util.List;

public interface Repository<T> {

	void getConfFromJSON(String configFile);

	boolean isValid();

	List<T> getMaps();

	String getVersion();

	String getInfo();
	
}
