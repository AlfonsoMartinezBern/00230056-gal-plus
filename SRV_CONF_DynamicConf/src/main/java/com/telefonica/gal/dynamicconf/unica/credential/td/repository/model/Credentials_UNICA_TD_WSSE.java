package com.telefonica.gal.dynamicconf.unica.credential.td.repository.model;

import java.util.List;

public class Credentials_UNICA_TD_WSSE {

	private String instanceID;
	private String platformID;
	private String uri;
	private List<Credential_UNICA_TD_WSSE> credentials;


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

	public List<Credential_UNICA_TD_WSSE> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credential_UNICA_TD_WSSE> credentials) {
		this.credentials = credentials;
	}
}
