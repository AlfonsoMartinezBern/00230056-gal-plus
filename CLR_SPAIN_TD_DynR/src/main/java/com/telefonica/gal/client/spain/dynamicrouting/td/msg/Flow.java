package com.telefonica.gal.client.spain.dynamicrouting.td.msg;

public class Flow{
	
    private int step;
    private String endpointID;
    private String type;
    private boolean active;
    private boolean synchronous;
    private boolean transformation;

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

    public boolean isSynchronous() {
        return synchronous;
    }

    public void setSynchronous(boolean synchronous) {
        this.synchronous = synchronous;
    }

    public boolean isTransformation() {
        return transformation;
    }

    public void setTransformation(boolean transformation) {
        this.transformation = transformation;
    }

    @Override
    public String toString() {
        return "Flow{" +
                "step=" + step +
                ", endpointID='" + endpointID + '\'' +
                ", type='" + type + '\'' +
                ", active=" + active +
                ", synchronous=" + synchronous +
                ", transformation=" + transformation +
                '}';
    }
}
