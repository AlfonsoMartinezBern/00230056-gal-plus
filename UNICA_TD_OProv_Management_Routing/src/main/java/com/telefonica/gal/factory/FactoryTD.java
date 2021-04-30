package com.telefonica.gal.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.Flow;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.interfaceWs.wsGvp.WsGvp;
import com.telefonica.gal.interfaceWs.wsUmg.WsUmg;
import com.telefonica.gal.utils.WsUtils;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;

@Component
public class FactoryTD<T> {

	public CreateUserResponse invokeWs(T routingTD, T request, Map<String, Object> hashMap) {
		CreateUserResponse response = new CreateUserResponse();

		List<InvokeWsFactory> invokeWsList = getInvokeWs(routingTD, request, hashMap);

		if (invokeWsList.size() == 1) {
			return (CreateUserResponse) invokeWsList.get(0).getInvokeWs().invoke();
		}

		for (InvokeWsFactory invokeWs : invokeWsList) {
			if (!invokeWs.isSynchronous() && invokeWs.getType().equals("source")) {
				AsyncFactory asyncFactory = new AsyncFactory(invokeWsList);
				asyncFactory.start();
				return (CreateUserResponse) invokeWs.getInvokeWs().invoke();
			}

			if (invokeWs.getType().equals("source")) {
				response = (CreateUserResponse) invokeWs.getInvokeWs().invoke();
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
		if (endpoint.getEndpointType().equals(WsUtils.GVP)) {
			return new InvokeWsFactory(new WsGvp(endpoint, request, hashMap), flowType, flowSynchronous);
		} else if (endpoint.getEndpointType().equals(WsUtils.UMG)) {
			return new InvokeWsFactory(new WsUmg(endpoint, request, hashMap), flowType, flowSynchronous);
		}
		return null;
	}

}
