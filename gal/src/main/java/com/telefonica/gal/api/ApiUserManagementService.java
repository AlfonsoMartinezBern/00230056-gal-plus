package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.handler.MessageContext;

public interface ApiUserManagementService {
    CreateUserResponse callWsUserManagementCreateUser (CreateUser createUser, MessageContext messageContext);
}
