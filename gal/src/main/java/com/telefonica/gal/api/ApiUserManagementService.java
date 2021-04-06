package com.telefonica.gal.api;


import javax.xml.bind.JAXBException;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeaderElement;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;

public interface ApiUserManagementService {
   
    
    CreateUserResponse callWsUserManagementCreateUser (CreateUser createUser,  
    		MessageContext context) throws Exception;

    
}
