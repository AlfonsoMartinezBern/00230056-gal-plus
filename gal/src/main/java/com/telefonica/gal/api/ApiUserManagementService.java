package com.telefonica.gal.api;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.northbound.provManagement.UserCreationType;

public interface ApiUserManagementService {
    CreateUserResponse callWsUserManagementCreateUser (UserCreationType userCreationType);
}
