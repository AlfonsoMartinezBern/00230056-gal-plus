package com.telefonica.gal.api;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import com.telefonica.gal.service.userManagement.UserManagementService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;

@Endpoint
public class ApiUserManagementServiceImpl implements ApiUserManagementService {

    public static final String NAMESPACE = "http://www.telefonica.com/wsdl/UNICA/SOAP/OProv_Management/v7/local";

    private final HttpServletRequest httpServletRequest;

    private final UserManagementService userManagementService;


    
  

    public ApiUserManagementServiceImpl(UserManagementService userManagementService, HttpServletRequest httpServletRequest) {
        this.userManagementService = userManagementService;
        this.httpServletRequest = httpServletRequest;


    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "createUser")
    @ResponsePayload
    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload CreateUser createUserRequest,
    		MessageContext context) throws Exception {
    
        
        return userManagementService.callWsUserManagementCreateUser(createUserRequest, context);

         
    }
    
    
	}



