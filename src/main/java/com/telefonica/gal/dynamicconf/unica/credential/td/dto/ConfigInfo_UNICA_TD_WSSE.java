package com.telefonica.gal.dynamicconf.unica.credential.td.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import com.telefonica.gal.dynamicconf.unica.credential.td.repository.model.Credential_UNICA_TD_WSSE;

import lombok.Getter;
import lombok.Setter;


@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ConfigInfo_UNICA_TD_WSSE extends MessageResponse{
	private List<Credential_UNICA_TD_WSSE> credentials;

	

	public ConfigInfo_UNICA_TD_WSSE(List<Credential_UNICA_TD_WSSE> credentials) {
		super(credentials==null?"KO":"OK", credentials==null?"No Data Found":null);
		this.credentials = credentials;
	}
	

	
}
