package com.telefonica.gal.dynamicconf.unica.credential.td.dto;

public class ConfigKey_UNICA_TD_WSSE {
	
	private String instanceID;
	private String platformID;
	private String uri;

	public ConfigKey_UNICA_TD_WSSE(String instanceID, String platformID, String uri) {
		this.instanceID = instanceID;
		this.platformID = platformID;
		this.uri = uri;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "ConfigKey_UNICA_TD_WSSE{" +
				"instanceID='" + instanceID + '\'' +
				", platformID='" + platformID + '\'' +
				", uri='" + uri + '\'' +
				'}';
	}
}
