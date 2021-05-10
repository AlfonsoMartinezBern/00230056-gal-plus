package com.telefonica.gal.dynamicconf.repository;

import java.util.ArrayList;

public class DynamicConfigRoutes_DTO<T> extends DynamicConfigJSON_DTO {
	private ArrayList<T> routes;

	public ArrayList<T> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<T> routes) {
		this.routes = routes;
	}
}
