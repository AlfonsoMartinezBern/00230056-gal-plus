package com.telefonica.gal.dynamicconf.unica.bu.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telefonica.gal.dynamicconf.repository.model.Flow;

import java.util.List;

public class Route_UNICA_BU {

	private String instanceID;
	private String platformID;
	private String operationType;
	private List<Endpoint_UNICA_BU> endpoints;
	private List<Flow> flows;

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getPlatformID() {
		return platformID;
	}

	public void setPlatformID(String platformID) {
		this.platformID = platformID;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public List<Endpoint_UNICA_BU> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint_UNICA_BU> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

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
