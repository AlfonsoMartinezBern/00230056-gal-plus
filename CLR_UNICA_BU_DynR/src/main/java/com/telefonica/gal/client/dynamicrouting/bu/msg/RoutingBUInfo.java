package com.telefonica.gal.client.dynamicrouting.bu.msg;

import java.util.List;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter

public class RoutingBUInfo extends MessageResponse{
	
	private List<Endpoint_UNICA_BU> endpoints;
	private List<Flow> flows;
	
	@Override
	public String toString() {
		if (this.getResult()==null) {
			
			return null;
		}
		String flows = this.flows!=null? this.getFlows().toString():"null";
		String endpoints = this.endpoints!=null? this.getEndpoints().toString():"null";
		
		return "RoutingTDInfo(result="+ this.getResult()+", message=" + this.getMessage() + ", flows="+ flows +", endpoints="+ endpoints+")";
	}
}
