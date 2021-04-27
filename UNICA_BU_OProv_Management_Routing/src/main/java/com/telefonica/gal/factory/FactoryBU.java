package com.telefonica.gal.factory;

import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.interfaceWs.WsRegistrationBU;
import org.springframework.stereotype.Component;

@Component
public class FactoryBU<T> {
    public InvokeWs getInvokeWs(T getAccountForDevice) {
        return new WsRegistrationBU(getAccountForDevice);
    }
}
