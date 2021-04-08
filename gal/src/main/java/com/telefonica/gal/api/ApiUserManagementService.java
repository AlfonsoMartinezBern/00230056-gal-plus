package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import org.springframework.ws.context.MessageContext;

public interface ApiUserManagementService {
    
    CreateUserResponse callWsUserManagementCreateUser (CreateUser createUser,  
    		MessageContext context) throws Exception;
    
}
