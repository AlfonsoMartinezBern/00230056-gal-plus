package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.identityManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.identityManagement.AuthenticateUserResponse;
import com.telefonica.gal.wsdl.identityManagement.ClientException;
import com.telefonica.gal.wsdl.identityManagement.ServerException;
import com.telefonica.gal.wsdl.identityManagement.UserIdType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ApiServiceImpl implements ApiService {

    @PayloadRoot(namespace = "http://www.telefonica.com/wsdl/UNICA/SOAP/IAM_IdentityManagement/v2/local",
            localPart = "authenticateUser")
    @ResponsePayload
    public AuthenticateUserResponse callWsIdentityManagementAuthenticateUser(@RequestPayload AuthenticateUser authenticateUser)
            throws ServerException, ClientException {

        AuthenticateUserResponse response = new AuthenticateUserResponse();
        UserIdType userIdType = new UserIdType();
        userIdType.setAlias("GAL Telefonica");

        response.setUserId(userIdType);
        response.setPendingVerification(true);
        response.setVerificationMeans("Prueba");

        return response;
    }
}
