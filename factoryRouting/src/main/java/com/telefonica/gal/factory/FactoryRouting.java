package com.telefonica.gal.factory;

import com.telefonica.gal.interfaceWs.InvokeWs;
import org.springframework.stereotype.Component;

@Component
public interface FactoryRouting<T> {

    InvokeWs<T> getInvokeWs(String endPoint, String operationId, int instanceId, int platformId, String url,
                         T user, T serviceID);

}
