package com.telefonica.gal.client.dynamicrouting.td.msg;

public class RoutingTDKey {
	
	//private String serviceID;
	private String operationTD;
	//private String uri;
	
	public RoutingTDKey(String serviceID, String operationTD, String uri) {
		//this.serviceID = serviceID;
		this.operationTD = operationTD;
		//this.uri = uri;
	}

	public String getOperationTD() {
		return operationTD;
	}

	public void setOperationTD(String operationTD) {
		this.operationTD = operationTD;
	}

	@Override
	public String toString() {
		return "RoutingTDKey{" +
				"operationTD='" + operationTD + '\'' +
				'}';
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
	if(this.operationTD == key.operationTD) {
		return true;
	}
		return false;
	}

	

}
