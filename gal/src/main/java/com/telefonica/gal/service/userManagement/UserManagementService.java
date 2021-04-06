package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.header.wsa.facade.WSAHeaderImpl;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;

public interface UserManagementService {
//    CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser, String serviceId);



	CreateUserResponse callWsUserManagementCreateUser(CreateUser createUserRequest, WSAHeaderImpl wsaHeader);
}
