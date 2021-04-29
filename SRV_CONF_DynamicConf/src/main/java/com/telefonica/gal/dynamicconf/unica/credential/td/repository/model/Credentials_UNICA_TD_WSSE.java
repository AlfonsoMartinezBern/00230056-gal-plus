package com.telefonica.gal.dynamicconf.unica.credential.td.repository.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credentials_UNICA_TD_WSSE {

	private String instanceID;
	private String platformID;
	private String uri;
	private List<Credential_UNICA_TD_WSSE> credentials;

}
