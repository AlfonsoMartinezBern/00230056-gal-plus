package com.telefonica.gal.dynamicrouting.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Endpoint{
    private String id;
    private int instanceID;
    private int platformID;
    private String targetEndpoint;
    private String alterFlow;
    private String endpointType;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(int instanceID) {
		this.instanceID = instanceID;
	}
	public int getPlatformID() {
		return platformID;
	}
	public void setPlatformID(int platformID) {
		this.platformID = platformID;
	}
	public String getTargetEndpoint() {
		return targetEndpoint;
	}
	public void setTargetEndpoint(String targetEndpoint) {
		this.targetEndpoint = targetEndpoint;
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
}