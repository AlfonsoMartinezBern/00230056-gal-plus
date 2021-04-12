package com.telefonica.gal.dynamicrouting.model;

public class Flow{
    private int step;
    private String endpointID;
    private String type;
    private boolean active;
    
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getEndpointID() {
		return endpointID;
	}
	public void setEndpointID(String endpointID) {
		this.endpointID = endpointID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
    
    
}
