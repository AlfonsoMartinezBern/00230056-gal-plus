package com.telefonica.gal.dinamicrouting.dto;


public class RoutingTDKey {
	
	private String serviceID;
	private String operationTD;
	private String uri;
	
	public RoutingTDKey(String serviceID, String operationTD, String uri) {
		super();
		this.serviceID = serviceID;
		this.operationTD = operationTD;
		this.uri = uri;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		
	if(getClass() != obj.getClass()) {
		return false;
	}
	RoutingTDKey key = (RoutingTDKey) obj;
	if(this.serviceID==key.serviceID && this.operationTD == key.operationTD && this.uri == key.uri) {
		return true;
	}
		return false;
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
