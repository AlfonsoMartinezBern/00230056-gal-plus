package com.telefonica.gal.client.spain.dynamicrouting.td.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Endpoint{
    private String id;
    private String endpointType;
    private String targetEndpoint;

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

    public String getTargetEndpoint() {
        return targetEndpoint;
    }

    public void setTargetEndpoint(String targetEndpoint) {
        this.targetEndpoint = targetEndpoint;
    }

    public boolean existId(String id) {
        return this.id.equals(id);

    }

   /* @Override
    public String toString() {
        return "Endpoint{" +
                "id='" + id + '\'' +
                ", endpointType='" + endpointType + '\'' +
                ", targetEndpoint='" + targetEndpoint + '\'' +
                '}';
    }*/
}