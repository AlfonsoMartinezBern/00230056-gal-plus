package com.telefonica.gal.wsRouting.wsRegistrationBU;

import com.telefonica.gal.wsdl.northbound.provManagement.ChangePassword;
import com.telefonica.gal.wsdl.northbound.provManagement.ClientException;
import com.telefonica.gal.wsdl.northbound.provManagement.ExtensionType;
import com.telefonica.gal.wsdl.northbound.provManagement.IdentityManagementPort;
import com.telefonica.gal.wsdl.northbound.provManagement.RememberPassword;
import com.telefonica.gal.wsdl.northbound.provManagement.RememberUser;
import com.telefonica.gal.wsdl.northbound.provManagement.ServerException;
import com.telefonica.gal.wsdl.northbound.provManagement.UserIdType;
import org.springframework.stereotype.Service;

import javax.xml.ws.Holder;

@Service
public class WsRegistrationService implements IdentityManagementPort {
    @Override
    public void authenticateUser(UserIdType user, String password, Long userRole, ExtensionType additionalCredentials,
                                 Holder<UserIdType> userId, Holder<Boolean> pendingVerification,
                                 Holder<String> verificationMeans) throws ServerException, ClientException {

    }

    @Override
    public void rememberPassword(RememberPassword parameters) throws ServerException, ClientException {

    }

    @Override
    public void rememberUser(RememberUser parameters) throws ServerException, ClientException {

    }

    @Override
    public void changePassword(ChangePassword parameters) throws ServerException, ClientException {

    }

    @Override
    public void isCustomer(UserIdType userIdentity, Holder<Boolean> registeredUser, Holder<Integer> servingOB) throws ServerException, ClientException {

    }
}
