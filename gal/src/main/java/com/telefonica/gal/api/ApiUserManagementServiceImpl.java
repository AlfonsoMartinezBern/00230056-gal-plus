package com.telefonica.gal.api;

import com.telefonica.gal.service.userManagement.UserManagementService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ApiUserManagementServiceImpl implements ApiUserManagementService {
    private final UserManagementService userManagementService;

    public ApiUserManagementServiceImpl(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PayloadRoot(namespace = "http://www.telefonica.com/wsdl/UNICA/SOAP/OProv_Management/v7/local",
            localPart = "createUser")
    @ResponsePayload
    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload CreateUser createUser) {
        CreateUserResponse response = new CreateUserResponse();

        response = userManagementService.callWsUserManagementCreateUser(createUser);

        return response;
    }
}
