package com.telefonica.gal.client.dynamicrouting.td.msg;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Route{
	
	private String serviceID;
	private String operationTD;
	private String uri;
	private List<Endpoint> endpoints;
	private List<Flow> flows;

}
