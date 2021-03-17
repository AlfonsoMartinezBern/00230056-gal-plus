package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.northbound.provManagement.UserCreationType;
import com.telefonica.gal.wsdl.northbound.provManagement.UserIdType;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    private final WsITDregistrationService wsITDregistrationService;

    public UserManagementServiceImpl(WsITDregistrationService wsITDregistrationService) {
        this.wsITDregistrationService = wsITDregistrationService;
    }

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser) {

        //wsITDregistrationService.createUser();
        return null;
    }


    //TODO validar mensaje
    //TODO invocar Routing
    //TODO validar si es IPTV o OTT
    //TODO Consumir servicio SOAP GVP o UMG
}
