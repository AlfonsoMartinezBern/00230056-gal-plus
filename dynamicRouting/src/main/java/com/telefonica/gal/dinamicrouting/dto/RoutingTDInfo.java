package com.telefonica.gal.dinamicrouting.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dinamicrouting.model.Endpoint;
import com.telefonica.gal.dinamicrouting.model.Flow;

@JsonInclude(Include.NON_NULL)
public class RoutingTDInfo extends MessageResponse{
	private List<Endpoint> endpoints;
	private List<Flow> flows;
	
	
	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public RoutingTDInfo(List<Endpoint> endpoints, List<Flow> flows) {
		super(endpoints==null?"KO":"OK", endpoints==null?"No Data Found":null);
		this.endpoints = endpoints;
		this.flows = flows!=null && flows.size()>0?flows:null;
	}
	

	
}
