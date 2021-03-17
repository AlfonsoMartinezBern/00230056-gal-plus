package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.identityManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.identityManagement.AuthenticateUserResponse;
import com.telefonica.gal.wsdl.identityManagement.ClientException;
import com.telefonica.gal.wsdl.identityManagement.ServerException;

public interface ApiService {
    AuthenticateUserResponse callWsIdentityManagementAuthenticateUser(AuthenticateUser authenticateUser)
            throws ServerException, ClientException;
}
