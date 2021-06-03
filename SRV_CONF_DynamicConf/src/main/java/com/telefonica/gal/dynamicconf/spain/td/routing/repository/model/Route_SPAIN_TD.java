package com.telefonica.gal.dynamicconf.spain.td.routing.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telefonica.gal.dynamicconf.repository.model.Flow;

import java.util.List;

public class Route_SPAIN_TD {
    private String operationTD;

    private List<Endpoint_SPAIN_TD> endpoints;
    private List<Flow> flows;

    public String getOperationTD() {
        return operationTD;
    }

    public void setOperationTD(String operationTD) {
        this.operationTD = operationTD;
    }

    public List<Endpoint_SPAIN_TD> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint_SPAIN_TD> endpoints) {
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
            for (Endpoint_SPAIN_TD endpoint : this.endpoints) {
                if (endpoint.getId() == null)
                    return false;
                if (endpoint.existId(endpointID))
                    return true;
            }
        return false;
    }

    @JsonIgnore
    public Endpoint_SPAIN_TD getEndpointsById(String endpointID) {
        for (Endpoint_SPAIN_TD endpoint : this.endpoints) {
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
