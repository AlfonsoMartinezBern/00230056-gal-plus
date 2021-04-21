package com.telefonica.gal.factory;

import com.telefonica.gal.utils.WsUtils;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsRouting.wsGvp.WsGvp;
import com.telefonica.gal.wsRouting.wsUmg.WsUmg;
import org.springframework.stereotype.Component;

@Component
public class FactoryRouting<T> {

    public InvokeWs getInvokeWs(String endPoint, String operationId, int instanceId, int platformId, String url,
                                T user, T serviceID) {

        switch (endPoint) {
            case WsUtils.GVP:
                return new WsGvp(instanceId, platformId, operationId, url, user, serviceID);
            case WsUtils.UMG:
                return new WsUmg(instanceId, platformId, operationId, url, user, serviceID);
        }
        return null;
    }
}
