package com.telefonica.gal.factory;

import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.interfaceWs.wsGvp.WsGvp;
import com.telefonica.gal.interfaceWs.wsUmg.WsUmg;
import com.telefonica.gal.utils.WsUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FactoryTD<T> {

    public InvokeWs getInvokeWs(T routingTD, T request, Map<String, Object> hashMap) {

        RoutingTDInfo routingTDInfo = new RoutingTDInfo();
        routingTDInfo = (RoutingTDInfo) routingTD;

        switch (routingTDInfo.getEndpoints().get(0).getEndpointType()) {
            case WsUtils.GVP:
                return new WsGvp(routingTDInfo, request, hashMap);
            case WsUtils.UMG:
                return new WsUmg(routingTDInfo, request, hashMap);
        }
        return null;
    }
}
