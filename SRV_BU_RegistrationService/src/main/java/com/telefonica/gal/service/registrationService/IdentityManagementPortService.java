package com.telefonica.gal.service.registrationService;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.southbound.registration.GetAccountForDevice;
import org.springframework.ws.context.MessageContext;

public interface IdentityManagementPortService {

    void callWsAuthenticateUser(GetAccountForDevice getAccountForDevice, MessageContext context) throws Exception;

}
