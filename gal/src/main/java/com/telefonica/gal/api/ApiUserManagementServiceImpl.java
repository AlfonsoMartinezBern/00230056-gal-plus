package com.telefonica.gal.api;


import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import com.telefonica.gal.configuration.ConfigurationHandler;
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
    		@SoapHeader(value = "{http://www.w3.org/2005/08/addressing}Action") SoapHeaderElement action,
    		@SoapHeader(value = "{http://www.w3.org/2005/08/addressing}From") SoapHeaderElement from,
    		@SoapHeader(value = "{http://www.w3.org/2005/08/addressing}To") SoapHeaderElement to) {
    	 System.out.println("configurationHandler_callWsUserManagementCreateUser");
    	 System.out.println(action.getName()+": "+action.getText());
    	 System.out.println(to.getName()+": "+ to.getText());
    	 System.out.println(from.getName());
    	 
    	 

        String serviceId = httpServletRequest.getHeader("wsa05");


        CreateUserResponse response = new CreateUserResponse();
        response = userManagementService.callWsUserManagementCreateUser(createUserRequest, serviceId);

        return response;
    }
    



}
