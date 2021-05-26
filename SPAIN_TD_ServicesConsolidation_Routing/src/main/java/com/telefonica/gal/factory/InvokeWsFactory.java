package com.telefonica.gal.factory;

import com.telefonica.gal.interfaceWs.InvokeWs;

public class InvokeWsFactory {
    protected InvokeWs invokeWs;
    protected String type;
    protected boolean synchronous;

    public InvokeWsFactory(InvokeWs invokeWs, String type, boolean synchronous) {
        this.invokeWs = invokeWs;
        this.type = type;
        this.synchronous = synchronous;
    }

    public InvokeWs getInvokeWs() {
        return invokeWs;
    }

    public void setInvokeWs(InvokeWs invokeWs) {
        this.invokeWs = invokeWs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSynchronous() {
        return synchronous;
    }

    public void setSynchronous(boolean synchronous) {
        this.synchronous = synchronous;
    }

    @Override
    public String toString() {
        return "InvokeWsFactory{" +
                "invokeWs=" + invokeWs +
                ", type='" + type + '\'' +
                ", synchronous=" + synchronous +
                '}';
    }
}
