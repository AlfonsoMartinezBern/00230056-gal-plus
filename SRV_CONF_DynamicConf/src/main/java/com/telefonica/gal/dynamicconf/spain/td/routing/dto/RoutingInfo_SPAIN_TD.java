package com.telefonica.gal.dynamicconf.spain.td.routing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.telefonica.gal.dynamicconf.generic.dto.MessageResponse;
import com.telefonica.gal.dynamicconf.repository.model.Flow;
import com.telefonica.gal.dynamicconf.spain.td.routing.repository.model.Endpoint_SPAIN_TD;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoutingInfo_SPAIN_TD extends MessageResponse {
    private List<Endpoint_SPAIN_TD> endpoints;
    private List<Flow> flows;

    public List<Endpoint_SPAIN_TD> getEndpoints() {
        return endpoints;
    }

    public List<Flow> getFlows() {
        return flows;
    }

    public RoutingInfo_SPAIN_TD(List<Endpoint_SPAIN_TD> endpoints, List<Flow> flows) {
        super(endpoints==null?"KO":"OK", endpoints==null?"No Data Found":null);
        this.endpoints = endpoints;
        this.flows = flows!=null && flows.size()>0?flows:null;
    }
}
