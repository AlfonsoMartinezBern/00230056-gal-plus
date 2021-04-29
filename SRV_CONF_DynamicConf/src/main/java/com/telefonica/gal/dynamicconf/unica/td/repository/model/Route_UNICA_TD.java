package com.telefonica.gal.dynamicconf.unica.td.repository.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telefonica.gal.dynamicconf.repository.model.Flow;

public class Route_UNICA_TD {

	private String serviceID;
	private String operationTD;
	private String uri;
	private List<Endpoint_UNICA_TD> endpoints;
	private List<Flow> flows;

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getOperationTD() {
		return operationTD;
	}

	public void setOperationTD(String operationTD) {
		this.operationTD = operationTD;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Endpoint_UNICA_TD> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint_UNICA_TD> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlow(List<Flow> flows) {
		this.flows = flows;
	}
	
	@JsonIgnore
	public boolean isFlowForRoute() {
		if(this.flows==null) {
			return true;
		}
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
			for (Endpoint_UNICA_TD endpoint : this.endpoints) {
				if (endpoint.getId() == null)
					return false;
				if (endpoint.existId(endpointID))
					return true;
			}
		return false;
	}

	@JsonIgnore
	public Endpoint_UNICA_TD getEndpointsById(String endpointID) {
		for (Endpoint_UNICA_TD endpoint : this.endpoints) {
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
