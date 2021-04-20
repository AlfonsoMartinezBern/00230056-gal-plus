package com.telefonica.gal.wsRouting.wsGvp;

import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WsGvp<T> implements InvokeWs {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsGvp.class);
    private final WsITDregistrationFactoryService wsITDregistrationFactoryService = new WsITDregistrationFactoryService();

    private int instanceId;
    private int platformId;
    private String operationId;
    private String url;
    private T user;
    private T response;

    public WsGvp(int instanceId, int platformId, String operationId, String url, T user) {
        this.instanceId = instanceId;
        this.platformId = platformId;
        this.operationId = operationId;
        this.user = user;
        this.url = url;
    }

    public T getResponse() {
        return response;
    }

    @Override
    public T invoke() {
        System.out.println("### Invocar Ws GVP ###");
       LOGGER.info("### Invocar Ws GVP ###");

       switch (operationId) {
           case "CreateUser":
               response = invokeCreateUser(instanceId, platformId, user);
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

        return null;
    }

    private T invokeCreateUser(int instanceId, int platformId, T user) {
        LOGGER.info("Operacion CreateUser de GVP");
        System.out.println("Operacion CreateUser de GVP");

        UserDataContract userDataContract = new UserDataContract();
        userDataContract = (UserDataContract) user;

        wsITDregistrationFactoryService.setURL(url);
        ResultDataContractOfstring response = wsITDregistrationFactoryService.createUser(
                instanceId, platformId, userDataContract);

        return (T) response;
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
