package com.telefonica.gal.dinamicrouting.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DynamicRoutingTDRepository{
	private String version;
	private String info;
    private ArrayList<Route> routes;
	


	public ArrayList<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
	
	public boolean isValid() {
		return isValidFlowsForRoutes() && !isMultipleEndpointsWith_No_Flow();
	}

	private boolean isMultipleEndpointsWith_No_Flow() {
		for (Route route : routes) {
			if(route.isMultipleEndpointsWith_No_Flow()) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidFlowsForRoutes() {
		for (Route route : routes) {
			if(!route.isFlowForRoute()) {
				return false;
			}
		}
		return true;
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
