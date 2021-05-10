package com.telefonica.gal.client.dynamicrouting.td.msg;

import java.util.List;

public class Route{
	
	private String serviceID;
	private String operationTD;
	private String uri;
	private List<Endpoint> endpoints;
	private List<Flow> flows;

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getOperationTD() {
		return operationTD;
	}

	public void setOperationTD(String operationTD) {
		this.operationTD = operationTD;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	@Override
	public String toString() {
		return "Route{" +
				"serviceID='" + serviceID + '\'' +
				", operationTD='" + operationTD + '\'' +
				", uri='" + uri + '\'' +
				", endpoints=" + endpoints +
				", flows=" + flows +
				'}';
	}
}
