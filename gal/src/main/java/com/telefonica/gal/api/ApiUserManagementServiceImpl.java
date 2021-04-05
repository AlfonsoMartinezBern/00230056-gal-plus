package com.telefonica.gal.api;

import com.telefonica.gal.configuration.ConfigurationHandler;
import com.telefonica.gal.service.userManagement.UserManagementService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

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

//    @PayloadRoot(namespace = NAMESPACE, localPart = "createUser")
//    @ResponsePayload
//    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload CreateUser createUserRequest, MessageContext messageContext) {
//    	 System.out.println("configurationHandler");
//        SOAPMessageContext soapMessageContext = (SOAPMessageContext) messageContext;
//       
//        configurationHandler.wsAddressInjectHandler().handleMessage(soapMessageContext);
//
//        String serviceId = httpServletRequest.getHeader("wsa05");
//
//
//        CreateUserResponse response = new CreateUserResponse();
//        response = userManagementService.callWsUserManagementCreateUser(createUserRequest, serviceId);
//
//        return response;
//    }
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "createUser")
    @ResponsePayload
    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload CreateUser createUserRequest) {
    	 System.out.println("configurationHandler");
//        SOAPMessageContext soapMessageContext = (SOAPMessageContext) messageContext;
//       
//        configurationHandler.wsAddressInjectHandler().handleMessage(soapMessageContext);

        String serviceId = httpServletRequest.getHeader("wsa05");


        CreateUserResponse response = new CreateUserResponse();
        response = userManagementService.callWsUserManagementCreateUser(createUserRequest, serviceId);

        return response;
    }


}
