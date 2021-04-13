package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import org.springframework.ws.context.MessageContext;

public interface UserManagementService_UMG {

	CreateUserResponse callWsUserManagementCreateUser(CreateUser createUserRequest, MessageContext context) throws Exception;
}
