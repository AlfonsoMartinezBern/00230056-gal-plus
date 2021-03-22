package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;

public interface UserManagementService {
    CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser);
}
