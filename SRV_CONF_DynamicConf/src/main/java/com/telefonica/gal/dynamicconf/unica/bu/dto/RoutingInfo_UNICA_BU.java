package com.telefonica.gal.dynamicconf.unica.bu.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.Endpoint_UNICA_BU;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@ToString
public class RoutingInfo_UNICA_BU extends MessageResponse{
	private List<Endpoint_UNICA_BU> endpoints;
	private List<Flow> flows;
	

	public RoutingInfo_UNICA_BU(List<Endpoint_UNICA_BU> endpoints, List<Flow> flows) {
		super(endpoints==null?"KO":"OK", endpoints==null?"No Data Found":null);
		this.endpoints = endpoints;
		this.flows = flows!=null && flows.size()>0?flows:null;
	}
	

	
}
