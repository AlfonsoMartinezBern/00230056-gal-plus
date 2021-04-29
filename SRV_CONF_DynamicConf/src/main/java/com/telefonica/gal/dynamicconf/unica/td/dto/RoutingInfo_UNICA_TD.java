package com.telefonica.gal.dynamicconf.unica.td.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Endpoint_UNICA_TD;


@JsonInclude(Include.NON_NULL)
public class RoutingInfo_UNICA_TD extends MessageResponse{
	private List<Endpoint_UNICA_TD> endpoints;
	private List<Flow> flows;
	
	
	public List<Endpoint_UNICA_TD> getEndpoints() {
		return endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public RoutingInfo_UNICA_TD(List<Endpoint_UNICA_TD> endpoints, List<Flow> flows) {
		
		super(endpoints==null?"KO":"OK", endpoints==null?"No Data Found":null);
		this.endpoints = endpoints;
		this.flows = flows!=null && flows.size()>0?flows:null;
	}
	

	
}
