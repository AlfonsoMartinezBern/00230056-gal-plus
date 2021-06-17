package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.factory;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Flow;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.provisionApi.model.InlineResponse200;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FactoryTD<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactoryTD.class.getName());

    public InlineResponse200 invokeWs(T routingTD, T request, Map<String, Object> hashMap) {
        InlineResponse200 response = new InlineResponse200();

        List<InvokeWsFactory> invokeWsList = getInvokeWs(routingTD, request, hashMap);

        if (invokeWsList.size() == 1) {
            return (InlineResponse200) invokeWsList.get(0).getInvokeWs().invoke();
        }

        for (InvokeWsFactory invokeWs : invokeWsList) {
            if (!invokeWs.isSynchronous() && invokeWs.getType().equals("source")) {
                AsyncFactory asyncFactory = new AsyncFactory(invokeWsList);
                asyncFactory.start();
                return (InlineResponse200) invokeWs.getInvokeWs().invoke();
            }

            if (invokeWs.getType().equals("source")) {
                response = (InlineResponse200) invokeWs.getInvokeWs().invoke();
            } else {
                invokeWs.getInvokeWs().invoke();
            }

        }
        return response;
    }

    private List<InvokeWsFactory> getInvokeWs(T routingTD, T request, Map<String, Object> hashMap) {

        RoutingTDInfo routingTDInfo = new RoutingTDInfo();
        routingTDInfo = (RoutingTDInfo) routingTD;

        List<InvokeWsFactory> response = new ArrayList<>();
        List<Flow> flowList = routingTDInfo.getFlows();

        if(flowList == null || flowList.size()==1) {
            Endpoint endpoint = (routingTDInfo.getEndpoints().get(0));
            response.add(invokeFactoryNoFlow(request, hashMap, endpoint));
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
            response.add(invokeFactoryWithFlow(request, hashMap, flow, endpoint));

        }

        return response;
    }

    private InvokeWsFactory invokeFactoryNoFlow(T request, Map<String, Object> hashMap, Endpoint endpoint) {
        return invokeFactory(request,hashMap,endpoint,"source",true);
    }

    private InvokeWsFactory invokeFactoryWithFlow(T request, Map<String, Object> hashMap, Flow flow, Endpoint endpoint) {
        return invokeFactory(request,hashMap,endpoint,flow.getType(),flow.isSynchronous());
    }

    private InvokeWsFactory invokeFactory(T request, Map<String, Object> hashMap, Endpoint endpoint,String flowType,boolean flowSynchronous) {
        if (endpoint.getEndpointType().equals("MIVIEWTV")) {
            return new InvokeWsFactory(new WsMiViewTv(endpoint, request), flowType, flowSynchronous);
        } else if (endpoint.getEndpointType().equals("TOP+")) {
            return new InvokeWsFactory(new WsTopPlus(endpoint, request), flowType, flowSynchronous);
        }
        return null;
    }

}
