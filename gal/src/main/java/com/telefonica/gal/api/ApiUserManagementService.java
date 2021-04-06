package com.telefonica.gal.api;

import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;

public interface ApiUserManagementService {
   
    CreateUserResponse callWsUserManagementCreateUser (CreateUser createUser,  
    		SoapHeaderElement action,
    		SoapHeaderElement from,
    		SoapHeaderElement to);

    
}
