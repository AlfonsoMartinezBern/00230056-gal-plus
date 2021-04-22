package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.ExtensionType;
import com.telefonica.gal.wsdl.northbound.provManagement.UserIdType;
import com.telefonica.gal.wsdl.southbound.registration.GetAccountForDeviceResultType;
import org.springframework.ws.context.MessageContext;

import javax.xml.ws.Holder;

public interface ApiRegistrationService {

    void callWsAuthenticateUser(AuthenticateUser authenticateUser, MessageContext context ) throws Exception;

}
