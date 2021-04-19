package com.telefonica.gal.factory;

import com.telefonica.gal.utils.WsUtils;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsRouting.wsGvp.WsGvp;
import com.telefonica.gal.wsRouting.wsUmg.WsUmg;

public class FactoryRouting<T> {

    public InvokeWs getInvokeWs(String endPoint, String operationId, int instanceId, int platformId, String url,
                                T user) {

        switch (endPoint) {
            case WsUtils.GVP:
                return new WsGvp(instanceId, platformId, operationId, url, user);
            case WsUtils.UMG:
                return new WsUmg();
        }
        return null;
    }
}
