package com.telefonica.gal.dynamicconf.spain.td.repository.model;

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
}
