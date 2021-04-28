package com.telefonica.gal.interfaceWs.wsUmg;

import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.mapper.umg.CreateUserRequestMapper_UMG;
import com.telefonica.gal.mapper.umg.CreateUserResponseMapper_UMG;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.serviceid.ServiceIdType;
import org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfstring;
import org.datacontract.schemas._2004._07.gvp_gal.UserDataContract;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class WsUmg<T> implements InvokeWs<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsUmg.class);

    public final static CreateUserRequestMapper_UMG CREATE_USER_REQUEST_MAPPER_UMG = Mappers.getMapper(
            CreateUserRequestMapper_UMG.class);

    public final static CreateUserResponseMapper_UMG CREATE_USER_RESPONSE_MAPPER_UMG = Mappers.getMapper(
            CreateUserResponseMapper_UMG.class);

    private final WsITDregistrationFactoryUMG wsITDregistrationFactoryUMG = new WsITDregistrationFactoryUMG();

    @Autowired
    Endpoint endpointTD;

    private Integer instanceId;
    private Integer platformId;
    private String operationId;
    private String url;
    private T endPoint;
    private T request;
    private T response;
    private T serviceID;
    private Map<T,T> hashMap;

    public WsUmg(T endPoint, T request, Map<T, T> hashMap ) {
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

    private T invokeRegisterDevices(Integer instanceId, Integer platformId, T serviceId, String uniqueId, T deviceInfoList) {
        return null;
    }

    private T invokeCreateUser(T routingTDInfo, T request, Map<T, T> map) {
        endpointTD = (Endpoint) routingTDInfo;
        serviceID = map.get("ServiceId");

        url = endpointTD.getTargetEndpoint();
        instanceId = endpointTD.getInstanceID();
        platformId = endpointTD.getPlatformID();
        UserDataContract userDataContract = new UserDataContract();

        userDataContract = ((CreateUser) request).getUserCreation().getEmail() == null ?
                CREATE_USER_REQUEST_MAPPER_UMG.userDataMapper_2(((CreateUser) request)) :
                CREATE_USER_REQUEST_MAPPER_UMG.userDataMapper((CreateUser) request);
        userDataContract.setServiceId((ServiceIdType) serviceID);

        wsITDregistrationFactoryUMG.setURL(url);
        ResultDataContractOfstring responseWsUmg = wsITDregistrationFactoryUMG.createUser(
                instanceId, platformId, (ServiceIdType) serviceID, userDataContract);

        CreateUserResponse createUserResponse = CREATE_USER_RESPONSE_MAPPER_UMG.createUserResponseMapper(responseWsUmg);

        return (T) createUserResponse;
    }

    private T invokeDeleteUser(Integer instanceId, Integer platformId, T serviceId, String uniqueId, String reason) {
        return null;
    }

    private T invokeEnableUser(Integer instanceId, Integer platformId, T serviceId, T user) {
        return null;
    }

    private T invokeRemoveDevicesFromAccount(T removeDevicesFromAccount) {
        return null;
    }

    private T invokeDisableUser(Integer instanceId, Integer platformId, T serviceId, String uniqueId, String reason) {
        return null;
    }

    private T invokeRemoveDevices(Integer instanceId, Integer platformId, T serviceId, String uniqueId, T deviceInfoList) {
        return null;
    }

    private T invokeModifyUser(Integer instanceId, Integer platformId, T serviceId, T user) {
        return null;
    }

}
