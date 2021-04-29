package com.telefonica.gal.interfaceWs.wsGvp;

import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.mapper.gvp.CreateUserRequestMapper;
import com.telefonica.gal.mapper.gvp.CreateUserResponseMapper;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class WsGvp<T> implements InvokeWs<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsGvp.class);

    private final static CreateUserRequestMapper CREATE_USER_REQUEST_MAPPER = Mappers.getMapper(
            CreateUserRequestMapper.class);

    private final static CreateUserResponseMapper CREATE_USER_RESPONSE_MAPPER = Mappers.getMapper(
            CreateUserResponseMapper.class);

    private final WsITDregistrationFactoryService wsITDregistrationFactoryService = new WsITDregistrationFactoryService();

    @Autowired
    Endpoint endpointTD;

    private int instanceId;
    private int platformId;
    private String operationId;
    private String url;
    private T endPoint;
    private T request;
    private T response;
    private T serviceID;
    private Map<T,T> hashMap;

    public WsGvp(T endPoint, T request, Map<T, T> hashMap) {
        this.endPoint = endPoint;
        this.request = request;
        this.hashMap = hashMap;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public T invoke() {
        operationId = hashMap.get("Operation").toString();

       switch (operationId) {
           case "CreateUser":
               response = invokeCreateUser(endPoint, request, hashMap);
               break;
           case "DeleteUser":
               //invokeDeleteUser(instanceId, platformId, uniqueId, newUniqueId, reason);
               break;
           case "ModifyUser":
               //invokeModifyUser(instanceId, platformId, user);
               break;
           case "EnableUser":
               //invokeEnableUser(instanceId, platformId, user);
               break;
           case "DisableUser":
               //invokeDisableUser(instanceId, platformId, uniqueId, newUniqueId, reason);
               break;
           default:
               break;
       }
        return response;
    }

    private T invokeCreateUser(T endPoint, T request, Map<T, T> map) {
        endpointTD = (Endpoint) endPoint;
        serviceID = map.get("ServiceIdGVP");

        url = endpointTD.getTargetEndpoint();
        instanceId = endpointTD.getInstanceID();
        platformId = endpointTD.getPlatformID();

        UserDataContract userDataContract = CREATE_USER_REQUEST_MAPPER.userDataMapper((CreateUser) request);
        userDataContract = ((CreateUser) request).getUserCreation().getEmail() == null ?
                CREATE_USER_REQUEST_MAPPER.userDataMapper_2(((CreateUser) request)) :
                CREATE_USER_REQUEST_MAPPER.userDataMapper((CreateUser) request);
        userDataContract.setServiceType((ServiceIdType) serviceID);

        wsITDregistrationFactoryService.setURL(url);
        ResultDataContractOfstring responseWs = wsITDregistrationFactoryService.createUser(
                instanceId, platformId, userDataContract);

        CreateUserResponse createUserResponse = CREATE_USER_RESPONSE_MAPPER.createUserResponseMapper(responseWs);

        return (T) createUserResponse;
    }

    private T invokeDeleteUser(int instanceId, int platformId, String uniqueId, String newUniqueId, String reason) {
        return null;
    }

    private T invokeEnableUser(int instanceId, int platformId, Object user) {
        return null;
    }

    private T invokeDisableUser(int instanceId, int platformId, String uniqueId, String newUniqueId, String reason) {
        return null;
    }

    private T invokeModifyUser(int instanceId, int platformId, Object user) {
        return null;
    }

}
