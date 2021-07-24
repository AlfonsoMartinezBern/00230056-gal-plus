package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.factory;

import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.interfaceWs.WsMiViewTv;
import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.interfaceWs.WsTopPlus;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Flow;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FactoryTD<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryTD.class.getName());

    public String invokeWs(T routingTD, T request, String adminCode) {
        String response = null;

        List<InvokeWsFactory> invokeWsList = getInvokeWs(routingTD, request, adminCode);

        if (invokeWsList.size() == 1) {
            return invokeWsList.get(0).getInvokeWs().invoke().toString();
        }

        for (InvokeWsFactory invokeWs : invokeWsList) {
            if (!invokeWs.isSynchronous() && invokeWs.getType().equals("source")) {
                AsyncFactory asyncFactory = new AsyncFactory(invokeWsList);
                asyncFactory.start();

                return invokeWs.getInvokeWs().invoke().toString();
            }

            if (invokeWs.getType().equals("source")) {
                response = invokeWs.getInvokeWs().invoke().toString();
            } else {
                invokeWs.getInvokeWs().invoke();
            }

        }
        return response;
    }

    private List<InvokeWsFactory> getInvokeWs(T routingTD, T request, String adminCode) {

        RoutingTDInfo routingTDInfo = new RoutingTDInfo();
        routingTDInfo = (RoutingTDInfo) routingTD;

        List<InvokeWsFactory> response = new ArrayList<>();
        List<Flow> flowList = routingTDInfo.getFlows();

        if(flowList == null || flowList.size()==1) {
            Endpoint endpoint = (routingTDInfo.getEndpoints().get(0));
            response.add(invokeFactoryNoFlow(request, adminCode, endpoint));
            return response;
        }

        Collections.sort(flowList, new Comparator<Flow>() {
            @Override
            public int compare(Flow flow1, Flow flow2) {
                return Integer.compare(flow1.getStep(), flow2.getStep());
            }
        });

        for (Flow flow: flowList) {
            Endpoint endpoint = (routingTDInfo.getEndpointById(flow.getEndpointID()));
            response.add(invokeFactoryWithFlow(request, adminCode, flow, endpoint));
        }

        return response;
    }

    private InvokeWsFactory invokeFactoryNoFlow(T request, String adminCode, Endpoint endpoint) {
        return invokeFactory(request,adminCode,endpoint,"source",true);
    }

    private InvokeWsFactory invokeFactoryWithFlow(T request, String adminCode, Flow flow, Endpoint endpoint) {
        return invokeFactory(request, adminCode,endpoint,flow.getType(),flow.isSynchronous());
    }

    private InvokeWsFactory invokeFactory(T request, String adminCode, Endpoint endpoint,String flowType,boolean flowSynchronous) {
        if (endpoint.getEndpointType().equals("MIVIEWTV")) {
            return new InvokeWsFactory(new WsMiViewTv(endpoint, request, adminCode), flowType, flowSynchronous);
        } else if (endpoint.getEndpointType().equals("TOP+")) {
            return new InvokeWsFactory(new WsTopPlus(endpoint, request, adminCode), flowType, flowSynchronous);
        }
        return null;
    }

}
