package com.telefonica.gal.dynamicconf.repository;

import java.util.ArrayList;

public class DynamicConfigCredentials_DTO<T> extends DynamicConfigJSON_DTO {
	 private ArrayList<T> credentials;

	public ArrayList<T> getCredentials() {
		return credentials;
	}

	public void setCredentials(ArrayList<T> credentials) {
		this.credentials = credentials;
	}
}
