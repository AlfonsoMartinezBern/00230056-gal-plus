package com.telefonica.gal.wsRouting.wsGvp;

import com.telefonica.gal.mapper.gvp.CreateUserRequestMapper;
import com.telefonica.gal.mapper.gvp.CreateUserResponseMapper;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WsGvp<T> implements InvokeWs<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsGvp.class);

    private final static CreateUserRequestMapper CREATE_USER_REQUEST_MAPPER = Mappers.getMapper(
            CreateUserRequestMapper.class);

    private final static CreateUserResponseMapper CREATE_USER_RESPONSE_MAPPER = Mappers.getMapper(
            CreateUserResponseMapper.class);

    private final WsITDregistrationFactoryService wsITDregistrationFactoryService = new WsITDregistrationFactoryService();

    private int instanceId;
    private int platformId;
    private String operationId;
    private String url;
    private T user;
    private T response;
    private T serviceID;

    public WsGvp(int instanceId, int platformId, String operationId, String url, T user, T serviceID) {
        this.instanceId = instanceId;
        this.platformId = platformId;
        this.operationId = operationId;
        this.user = user;
        this.url = url;
        this.serviceID = serviceID;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public T invoke() {
        System.out.println("### Invocar Ws GVP ###");
       LOGGER.info("### Invocar Ws GVP ###");

       switch (operationId) {
           case "CreateUser":
               response = invokeCreateUser(instanceId, platformId, user, serviceID);
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

    private T invokeCreateUser(int instanceId, int platformId, T createUser, T serviceID) {
        LOGGER.info("Operacion CreateUser de GVP");
        System.out.println("Operacion CreateUser de GVP");

        UserDataContract userDataContract = CREATE_USER_REQUEST_MAPPER.userDataMapper((CreateUser) createUser);
        userDataContract = ((CreateUser) createUser).getUserCreation().getEmail() == null ?
                CREATE_USER_REQUEST_MAPPER.userDataMapper_2(((CreateUser) createUser)) :
                CREATE_USER_REQUEST_MAPPER.userDataMapper((CreateUser) createUser);
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
