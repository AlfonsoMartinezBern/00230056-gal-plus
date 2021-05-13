package com.telefonica.gal.dynamicconf.unica.bu.dto;

public class RoutingKey_UNICA_BU {
	
	private String instanceID;
	private String platformID;
	private String operation;

	public RoutingKey_UNICA_BU(String instanceID, String platformID, String operation) {
		this.instanceID = instanceID;
		this.platformID = platformID;
		this.operation = operation;
	}

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getPlatformID() {
		return platformID;
	}

	public void setPlatformID(String platformID) {
		this.platformID = platformID;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "RoutingKey_UNICA_BU{" +
				"instanceID='" + instanceID + '\'' +
				", platformID='" + platformID + '\'' +
				", operation='" + operation + '\'' +
				'}';
	}
}
