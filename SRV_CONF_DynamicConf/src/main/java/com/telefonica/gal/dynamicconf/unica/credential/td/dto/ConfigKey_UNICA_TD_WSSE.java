package com.telefonica.gal.dynamicconf.unica.credential.td.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ConfigKey_UNICA_TD_WSSE {
	
	private String instanceID;
	private String platformID;
	private String uri;
	
}
