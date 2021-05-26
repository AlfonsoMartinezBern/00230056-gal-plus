package com.telefonica.gal.factory;

import java.util.List;

public class AsyncFactory extends Thread {
    private List<InvokeWsFactory> invokeWsFactoryList;


    public AsyncFactory(List<InvokeWsFactory> invokeWsFactoryList) {
        this.invokeWsFactoryList = invokeWsFactoryList;
    }

    @Override
    public void run() {
        for(InvokeWsFactory invoke : invokeWsFactoryList) {
            if(invoke.getType().equals("replica")) {
                invoke.getInvokeWs().invoke();
            }
        }
    }
}
