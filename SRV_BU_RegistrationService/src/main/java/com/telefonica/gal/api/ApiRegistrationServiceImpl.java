package com.telefonica.gal.api;

import com.telefonica.gal.service.registrationService.IdentityManagementPortService;
import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;

@Endpoint
public class ApiRegistrationServiceImpl implements ApiRegistrationService {

    public static final String NAMESPACE = "¿?"; // "http://www.telefonica.com/wsdl/UNICA/SOAP/OProv_Management/v7/local"

    private final HttpServletRequest httpServletRequest;

    private final IdentityManagementPortService identityManagementPortService;

    public ApiRegistrationServiceImpl(IdentityManagementPortService identityManagementPortService, HttpServletRequest httpServletRequest) {
        this.identityManagementPortService = identityManagementPortService;
        this.httpServletRequest = httpServletRequest;
    }


    @PayloadRoot(namespace = NAMESPACE, localPart = "authenticateUser")
    @ResponsePayload
    public void callWsAuthenticateUser(AuthenticateUser authenticateUser, MessageContext context ) throws Exception {
        identityManagementPortService.callWsAuthenticateUser( authenticateUser, context );
    }
}
