package com.telefonica.gal.api;

import com.telefonica.gal.service.registrationService.IdentityManagementPortService;
import com.telefonica.gal.wsdl.southbound.registration.GetAccountForDevice;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;

@Endpoint
public class ApiRegistrationServiceImpl implements ApiRegistrationService {

    public static final String NAMESPACE = "http://www.telefonica.com/wsdl/UNICA/SOAP/IAM_IdentityManagement/v2/interfaces";

    private final IdentityManagementPortService identityManagementPortService;

    public ApiRegistrationServiceImpl(IdentityManagementPortService identityManagementPortService, HttpServletRequest httpServletRequest) {
        this.identityManagementPortService = identityManagementPortService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "authenticateUser")
    @ResponsePayload
    public void callWsAuthenticateUser(GetAccountForDevice getAccountForDevice, MessageContext context ) throws Exception {
        identityManagementPortService.callWsAuthenticateUser( getAccountForDevice, context );
    }
}
