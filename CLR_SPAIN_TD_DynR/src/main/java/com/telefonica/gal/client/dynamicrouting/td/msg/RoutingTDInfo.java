package com.telefonica.gal.client.dynamicrouting.td.msg;

import java.util.List;

public class RoutingTDInfo extends MessageResponse{
	
	private List<Endpoint> endpoints;
	private List<Flow> flows;

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	@Override
	public String toString() {
		if (this.getResult()==null) {
			
			return null;
		}
		String flows = this.flows!=null? this.getFlows().toString():"null";
		String endpoints = this.endpoints!=null? this.getEndpoints().toString():"null";
		
		return "RoutingTDInfo(result="+ this.getResult()+", message=" + this.getMessage() + ", flows="+ flows +", endpoints="+ endpoints+")";
	}
	

	public Endpoint getEndpointById(String id) {
		for(Endpoint endpoint: endpoints) {
			if(endpoint.getId().equals(id)) {
				return endpoint;
			}
		}
		return null;
	}
}
