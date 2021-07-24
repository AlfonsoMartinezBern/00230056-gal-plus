package com.telefonica.gal.dynamicrouting.model;

import java.util.List;

public class Route {

	private String serviceID;
	private String operationTD;
	private String uri;
	private List<Endpoint> endpoints;
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

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlow(List<Flow> flows) {
		this.flows = flows;
	}

	public boolean isFlowForRoute() {
		for (Flow flow : this.flows) {
			if (flow.isActive() && !this.existRouteID(flow.getEndpointID())) {
				return false;
			}
		}

		return true;
	}

	private boolean existRouteID(String endpointID) {
		if (endpointID == null)
			return false;
		else
			for (Endpoint endpoint : this.endpoints) {
				if (endpoint.getId() == null)
					return false;
				if (endpoint.existId(endpointID))
					return true;
			}
		return false;
	}

	public Endpoint getEndpointsById(String endpointID) {
		for (Endpoint endpoint : this.endpoints) {
			if (endpoint.existId(endpointID)) {

				return endpoint;
			}
		}
		return null;
	}

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
