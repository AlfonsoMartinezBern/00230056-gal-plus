package com.telefonica.gal.service.userManagement;

import org.springframework.ws.context.MessageContext;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;

public interface UserManagementService {

	CreateUserResponse callWsUserManagementCreateUser(CreateUser createUserRequest, MessageContext context) throws Exception;
}
