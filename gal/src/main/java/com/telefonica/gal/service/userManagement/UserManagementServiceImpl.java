package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.northbound.provManagement.UserCreationType;
import com.telefonica.gal.wsdl.northbound.provManagement.UserIdType;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    private final WsITDregistrationService wsITDregistrationService;

    public UserManagementServiceImpl(WsITDregistrationService wsITDregistrationService) {
        this.wsITDregistrationService = wsITDregistrationService;
    }

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser) {
        ResultDataContractOfstring resultDataContractOfstring = new ResultDataContractOfstring();

        UserDataContract userDataContract = new UserDataContract();
        userDataContract.setUserId(123);

        resultDataContractOfstring =wsITDregistrationService.createUser(1,2,userDataContract);
        return null;
    }

}
