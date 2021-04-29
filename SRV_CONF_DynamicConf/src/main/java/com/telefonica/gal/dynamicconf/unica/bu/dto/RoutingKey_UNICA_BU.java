package com.telefonica.gal.dynamicconf.unica.bu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class RoutingKey_UNICA_BU {
	
	private String instanceID;
	private String platformID;
	private String operation;
	
	
}
