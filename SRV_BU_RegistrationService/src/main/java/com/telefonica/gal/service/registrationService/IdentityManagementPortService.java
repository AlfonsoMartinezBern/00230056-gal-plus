package com.telefonica.gal.service.registrationService;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import org.springframework.ws.context.MessageContext;

public interface IdentityManagementPortService {

    void callWsAuthenticateUser( AuthenticateUser authenticateUser, MessageContext context ) throws Exception;

}
