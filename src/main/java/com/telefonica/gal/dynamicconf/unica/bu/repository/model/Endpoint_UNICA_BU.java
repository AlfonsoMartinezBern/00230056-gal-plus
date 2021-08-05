package com.telefonica.gal.dynamicconf.unica.bu.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Endpoint_UNICA_BU{
    
	private String id;

    private String uri;
    
    private String targetEndpoint;
    
    private String wssUser;
    private String wssPassword;
    
    private String alterFlow;
    
    private String endpointType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTargetEndpoint() {
        return targetEndpoint;
    }

    public void setTargetEndpoint(String targetEndpoint) {
        this.targetEndpoint = targetEndpoint;
    }

    public String getWssUser() {
        return wssUser;
    }

    public void setWssUser(String wssUser) {
        this.wssUser = wssUser;
    }

    public String getWssPassword() {
        return wssPassword;
    }

    public void setWssPassword(String wssPassword) {
        this.wssPassword = wssPassword;
    }

    public String getAlterFlow() {
        return alterFlow;
    }

    public void setAlterFlow(String alterFlow) {
        this.alterFlow = alterFlow;
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

    @Override
    public String toString() {
        return "Endpoint_UNICA_BU{" +
                "id='" + id + '\'' +
                ", uri='" + uri + '\'' +
                ", targetEndpoint='" + targetEndpoint + '\'' +
                ", wssUser='" + wssUser + '\'' +
                ", wssPassword='" + wssPassword + '\'' +
                ", alterFlow='" + alterFlow + '\'' +
                ", endpointType='" + endpointType + '\'' +
                '}';
    }
}