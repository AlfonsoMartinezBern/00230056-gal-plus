package com.example.demo.apidemo;

public class DynamicRoutingDTO {
	
    private String serviceID;
    private String operationTD;
    private String uri;
    
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
    
}
