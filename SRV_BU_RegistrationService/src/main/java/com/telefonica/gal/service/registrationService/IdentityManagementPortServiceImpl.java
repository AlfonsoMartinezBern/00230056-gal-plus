package com.telefonica.gal.service.registrationService;

import com.telefonica.gal.header.wsa.WSAHeader;
import com.telefonica.gal.ws.registrationService.WsIdentityManagementPortService;
import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;

@Service
public class IdentityManagementPortServiceImpl implements IdentityManagementPortService {
    //private final static String AuthenticateUser = "AuthenticateUser";

    // MAPPERS: private final static CreateUserRequestMapper_UMG CREATE_USER_REQUEST_MAPPER_UMG =
    // Mappers.getMapper(CreateUserRequestMapper_UMG.class);

    private final WsIdentityManagementPortService wsIdentityManagementPortService;

    public IdentityManagementPortServiceImpl(WsIdentityManagementPortService wsIdentityManagementPortService) {
        this.wsIdentityManagementPortService = wsIdentityManagementPortService;
    }

    @Override
    public void callWsAuthenticateUser( AuthenticateUser authenticateUser, MessageContext context ) throws Exception {
        WSAHeader wsaHeader = new WSAHeader(context);

        /* UserIdType user;
        String password;
        Long userRole;
        ExtensionType additionalCredentials;
        Holder<UserIdType> userId;
        Holder<Boolean> pendingVerification;
        Holder<String> verificationMeans;*/

        // TODO DynamicRoutingBU

        //Mapper Request
        //Llamada BUService

        //Mapper Response

        //wsIdentityManagementPortService.setURL(url);
        wsIdentityManagementPortService.authenticateUser(user, password, userRole, additionalCredentials, userId, pendingVerification, verificationMeans);
    }
}
