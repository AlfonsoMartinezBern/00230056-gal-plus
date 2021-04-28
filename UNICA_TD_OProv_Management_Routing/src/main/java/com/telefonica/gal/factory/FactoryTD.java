package com.telefonica.gal.factory;

import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.interfaceWs.wsGvp.WsGvp;
import com.telefonica.gal.interfaceWs.wsUmg.WsUmg;
import com.telefonica.gal.utils.WsUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FactoryTD<T> {

    public InvokeWs getInvokeWs(T routingTD, T request, Map<String, Object> hashMap) {

        RoutingTDInfo routingTDInfo = new RoutingTDInfo();
        routingTDInfo = (RoutingTDInfo) routingTD;

        List<InvokeWs> response = new ArrayList<>();

        List<Endpoint> list = routingTDInfo.getEndpoints();

       list.stream().
               forEach(endpoint -> {
                   if (endpoint.getEndpointType().equals(WsUtils.GVP)){
                         response.add((InvokeWs) new WsGvp(endpoint, request, hashMap));
                   } else

                       if (endpoint.getEndpointType().equals(WsUtils.UMG)) {
                          response.add((InvokeWs) new WsUmg(endpoint, request, hashMap));
                       }
               });
       
        return response.get(0);
    }
}
