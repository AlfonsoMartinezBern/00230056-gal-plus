package com.telefonica.gal.client.dynamicrouting.td.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Endpoint{
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

    public Endpoint(String id, String endpointType) {
        this.id = id;
        this.endpointType = endpointType;
    }
}