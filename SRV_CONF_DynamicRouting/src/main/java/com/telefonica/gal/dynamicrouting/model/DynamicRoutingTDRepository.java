package com.telefonica.gal.dynamicrouting.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DynamicRoutingTDRepository extends DynamicRoutingTDRepositoryValidator{
	private String version;
	private String info;
    private ArrayList<Route> routes;
	
	public ArrayList<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
