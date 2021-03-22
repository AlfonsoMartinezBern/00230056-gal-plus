package com.telefonica.gal.dynamicrouting.tdo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RoutingTDInfo extends MessageResponse{
	private List<Endpoint> endpoints;
	private List<Flow> flows;
	
	

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

//	public RoutingTDInfo(List<Endpoint> endpoints, List<Flow> flows) {
//		super(endpoints==null?"KO":"OK", endpoints==null?"No Data Found":null);
//		this.endpoints = endpoints;
//		this.flows = flows!=null && flows.size()>1?flows:null;
//	}
//	

	
}
