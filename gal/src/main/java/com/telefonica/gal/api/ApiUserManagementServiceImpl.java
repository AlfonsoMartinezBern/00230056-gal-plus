package com.telefonica.gal.api;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.telefonica.gal.configuration.ConfigurationHandler;
import com.telefonica.gal.header.wsa.facade.WSAHeaderImpl;
import com.telefonica.gal.service.userManagement.UserManagementService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;

@Endpoint
public class ApiUserManagementServiceImpl implements ApiUserManagementService {

    public static final String NAMESPACE = "http://www.telefonica.com/wsdl/UNICA/SOAP/OProv_Management/v7/local";

    private final HttpServletRequest httpServletRequest;

    private final UserManagementService userManagementService;

    private final ConfigurationHandler configurationHandler;
    
  

    public ApiUserManagementServiceImpl(UserManagementService userManagementService, HttpServletRequest httpServletRequest,
                                        ConfigurationHandler configurationHandler) {
        this.userManagementService = userManagementService;
        this.httpServletRequest = httpServletRequest;
        this.configurationHandler = configurationHandler;

    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "createUser")
    @ResponsePayload
    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload CreateUser createUserRequest,
    		MessageContext context) throws Exception {
    
        CreateUserResponse response = new CreateUserResponse();
        
        response = userManagementService.callWsUserManagementCreateUser(createUserRequest, new WSAHeaderImpl(context));

        return response;
    }
    
    
	}



