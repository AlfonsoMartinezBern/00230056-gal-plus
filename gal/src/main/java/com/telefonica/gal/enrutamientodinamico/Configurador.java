package com.telefonica.gal.enrutamientodinamico;

import java.util.Map;

public class Configurador {
	private Map<String, String> endpoints;
	private static Configurador miconfigurador = null;

	public static Configurador getConfigurador(Map<String, String> endpoints) {
		if (miconfigurador == null) {
			miconfigurador = new Configurador(endpoints);
		}
		return miconfigurador;
	}

	private Configurador(Map<String, String> endpoints) {
		this.setEndpoints(endpoints);
	}

	public Map<String, String> getEndpoints() {
		return endpoints;
	}

	public String getEndpoint(String service) {
		return endpoints.get(service);
	}

	public void setEndpoints(Map<String, String> endpoints) {
		this.endpoints = endpoints;
	}
	
	public void addEndpoint(String service, String endpoint) {
		this.endpoints.put(service, endpoint);
	}
	
	public void deleteEndpoint(String service) {
		this.endpoints.remove(service);
	}
}
