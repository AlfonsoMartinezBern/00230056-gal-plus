package com.telefonica.gal.factory;

import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.interfaceWs.wsGvp.WsGvp;
import com.telefonica.gal.interfaceWs.wsUmg.WsUmg;
import com.telefonica.gal.utils.WsUtils;
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
            case WsUtils.BU:
                //return new WsRegistrationBU(user);
        }
        return null;
    }
}
