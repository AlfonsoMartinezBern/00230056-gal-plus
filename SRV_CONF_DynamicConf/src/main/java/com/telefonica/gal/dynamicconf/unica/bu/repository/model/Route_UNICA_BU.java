package com.telefonica.gal.dynamicconf.unica.bu.repository.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telefonica.gal.dynamicconf.repository.model.Flow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Route_UNICA_BU {

	private String instanceID;
	private String platformID;
	private String operationType;
	private List<Endpoint_UNICA_BU> endpoints;
	private List<Flow> flows;

	@JsonIgnore
	public boolean isFlowForRoute() {
		for (Flow flow : this.flows) {
			if (flow.isActive() && !this.existRouteID(flow.getEndpointID())) {
				return false;
			}
		}

		return true;
	}

	@JsonIgnore
	private boolean existRouteID(String endpointID) {
		if (endpointID == null)
			return false;
		else
			for (Endpoint_UNICA_BU endpoint : this.endpoints) {
				if (endpoint.getId() == null)
					return false;
				if (endpoint.existId(endpointID))
					return true;
			}
		return false;
	}

	@JsonIgnore
	public Endpoint_UNICA_BU getEndpointsById(String endpointID) {
		for (Endpoint_UNICA_BU endpoint : this.endpoints) {
			if (endpoint.existId(endpointID)) {

				return endpoint;
			}
		}
		return null;
	}

	@JsonIgnore
	public boolean isMultipleEndpointsWith_No_Flow() {
		if (this.endpoints.size() == 1) {
			return false;
		}
		if (this.endpoints.size() > 1 && (this.flows == null || this.flows.isEmpty())) {
			return true;
		}
		return false;
	}

}
