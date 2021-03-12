package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.identityManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.identityManagement.AuthenticateUserResponse;
import com.telefonica.gal.wsdl.identityManagement.ClientException;
import com.telefonica.gal.wsdl.identityManagement.ServerException;

public interface ApiService {
    //TODO Validar con JM si se genera un DTO(XML) para los parámetros de entrada al método
    AuthenticateUserResponse callWsIdentityManagementAuthenticateUser(AuthenticateUser authenticateUser)
            throws ServerException, ClientException;
}
