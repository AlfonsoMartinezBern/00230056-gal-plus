package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;

public interface ApiUserManagementService {
    CreateUserResponse callWsUserManagementCreateUser (CreateUser createUser);
}
