package com.telefonica.gal.dynamicconf.spain.td.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endpoint_SPAIN_TD {
    private String id;
    private String endpointType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndpointType() {
        return endpointType;
    }

    public void setEndpointType(String endpointType) {
        this.endpointType = endpointType;
    }

    public boolean existId(String id) {
        return this.id.equals(id);

    }
}
