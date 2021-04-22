package com.telefonica.gal.wsRouting.wsUmg;

import com.telefonica.gal.mapper.umg.CreateUserRequestMapper_UMG;
import com.telefonica.gal.mapper.umg.CreateUserResponseMapper_UMG;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.serviceid.ServiceIdType;
import org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfstring;
import org.datacontract.schemas._2004._07.gvp_gal.UserDataContract;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WsUmg<T> implements InvokeWs<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsUmg.class);

    public final static CreateUserRequestMapper_UMG CREATE_USER_REQUEST_MAPPER_UMG = Mappers.getMapper(
            CreateUserRequestMapper_UMG.class);

    public final static CreateUserResponseMapper_UMG CREATE_USER_RESPONSE_MAPPER_UMG = Mappers.getMapper(
            CreateUserResponseMapper_UMG.class);

    private final WsITDregistrationFactoryUMG wsITDregistrationFactoryUMG = new WsITDregistrationFactoryUMG();

    private Integer instanceId;
    private Integer platformId;
    private String operationId;
    private String url;
    private T user;
    private T response;
    private T serviceID;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public T invoke() {
        System.out.println("### Invocar Ws UMG ###");

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

    public WsUmg(int instanceId, int platformId, String operationId, String url, T user, T serviceID) {
        this.instanceId = instanceId;
        this.platformId = platformId;
        this.operationId = operationId;
        this.user = user;
        this.url = url;
        this.serviceID = serviceID;
    }

    private T invokeRegisterDevices(Integer instanceId, Integer platformId, T serviceId, String uniqueId, T deviceInfoList) {
        return null;
    }

    private T invokeCreateUser(Integer instanceId, Integer platformId, T createUser, T serviceID) {
        System.out.println("Operacion CreateUser de UMG");
        UserDataContract userDataContract = new UserDataContract();

        userDataContract = ((CreateUser) createUser).getUserCreation().getEmail() == null ?
                CREATE_USER_REQUEST_MAPPER_UMG.userDataMapper_2(((CreateUser) createUser)) :
                CREATE_USER_REQUEST_MAPPER_UMG.userDataMapper((CreateUser) createUser);
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
