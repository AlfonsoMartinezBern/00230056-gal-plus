package com.telefonica.gal.factory;

import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.Flow;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.interfaceWs.wsGvp.WsGvp;
import com.telefonica.gal.interfaceWs.wsUmg.WsUmg;
import com.telefonica.gal.utils.WsUtils;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class FactoryTD<T> {

    public CreateUserResponse invokeWs(T routingTD, T request, Map<String, Object> hashMap) {
        CreateUserResponse response = new CreateUserResponse();
        List<ResponseGal> createUserResponseList = new ArrayList<ResponseGal>();

        List<ResponseGal> invokeWsList = getInvokeWs(routingTD, request, hashMap);

        for (ResponseGal invokeWs : invokeWsList) {
            if (invokeWs.getType().equals("source")) {
                return (CreateUserResponse) invokeWs.getCreateUserResponse().invoke();
            }
        }
        return null;
    }


    private List<ResponseGal> getInvokeWs(T routingTD, T request, Map<String, Object> hashMap) {

        RoutingTDInfo routingTDInfo = new RoutingTDInfo();
        routingTDInfo = (RoutingTDInfo) routingTD;

        //Listado resposse
        List<ResponseGal> response = new ArrayList<>();
        List<Flow> flowList = routingTDInfo.getFlows();

        Collections.sort(flowList, new Comparator<Flow>() {
            @Override
            public int compare(Flow flow1, Flow flow2) {
                return Integer.compare(flow1.getStep(), flow2.getStep());
            }
        });

        for (Flow flow: flowList) {

                Endpoint endpoint = (routingTDInfo.getEndpointById(flow.getEndpointID()));

                if (endpoint.getEndpointType().equals(WsUtils.GVP)){
                    //response.add(new ResponseGal() new WsGvp(endpoint, request, hashMap));
                    response.add(new ResponseGal(new WsGvp(endpoint, request, hashMap), flow.getType()));
                } else
                if (endpoint.getEndpointType().equals(WsUtils.UMG)) {
                    response.add(new ResponseGal(new WsUmg(endpoint,request,hashMap), flow.getType()));
                }


        }



        /*for(Flow flow : routingTD.getFlows()) {
            if(!flow.getType().equals("source")) {
                invokeEndPoints(routingTD.getEndpointById(flow.getEndpointID()));
            }
        }*/

        /*List<DestinationType> endPointIdList = getEndpointID(flowList);

        for(DestinationType destinationType: endPointIdList) {
            for (Endpoint endpoint: routingTDInfo.getEndpoints()) {
                if(endpoint.getId().equals(destinationType.getEndpointID())) {
                    if (endpoint.getEndpointType().equals(WsUtils.GVP)){
                        response.add((InvokeWs) new WsGvp(endpoint, request, hashMap, destinationType.getDestinationType()));
                    } else
                    if (endpoint.getEndpointType().equals(WsUtils.UMG)) {
                        response.add((InvokeWs) new WsUmg(endpoint, request, hashMap, destinationType.getDestinationType()));
                    }

                }
            }
        }*/

        return response;
    }

    private List<DestinationType> getEndpointID(final List<Flow> flowList) {
        List<DestinationType> destinationTypeList = new ArrayList<>();
        DestinationType destinationType;

        for(Flow flow : flowList) {
            destinationType = new DestinationType();
            destinationType.setDestinationType(flow.getType());
            destinationType.setEndpointID(flow.getEndpointID());
            destinationTypeList.add(destinationType);

        }
        return destinationTypeList;
    }


}
