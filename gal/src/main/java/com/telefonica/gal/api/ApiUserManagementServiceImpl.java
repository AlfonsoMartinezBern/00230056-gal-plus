package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.northbound.provManagement.UserCreationType;
import com.telefonica.gal.wsdl.northbound.provManagement.UserIdType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ApiUserManagementServiceImpl implements ApiUserManagementService {

    @PayloadRoot(namespace = "http://www.telefonica.com/wsdl/UNICA/SOAP/OProv_Management/v7/local",
            localPart = "createUser")
    @ResponsePayload
    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload UserCreationType userCreationType) {

        UserIdType userIdType = new UserIdType();
        userIdType.setAlias("ProvManagement");

        CreateUserResponse response = new CreateUserResponse();
        response.setGlobalUserID(userIdType);

        return response;
    }
}
