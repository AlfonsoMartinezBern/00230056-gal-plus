package com.telefonica.gal.dynamicconf.unica.td.dto;


public class RoutingKey_UNICA_TD {
	
	private String serviceID;
	private String operationTD;
	private String uri;
	
	public RoutingKey_UNICA_TD(String serviceID, String operationTD, String uri) {
		super();
		this.serviceID = serviceID;
		this.operationTD = operationTD;
		this.uri = uri;
	}
	
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
	
	@Override
	public String toString() {
		return "operationTD:"+ this.operationTD+" serviceID:"+this.serviceID+" uri:"+this.uri;
	}

}
