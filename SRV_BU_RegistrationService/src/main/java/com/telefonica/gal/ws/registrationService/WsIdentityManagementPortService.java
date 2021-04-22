package com.telefonica.gal.ws.registrationService;

import com.telefonica.gal.wsdl.northbound.provManagement.*;

import javax.xml.ws.Holder;
import java.net.MalformedURLException;
import java.net.URL;

public class WsIdentityManagementPortService implements IdentityManagementPort {

    private String url;

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public void authenticateUser(UserIdType user, String password, Long userRole, ExtensionType additionalCredentials, Holder<UserIdType> userId, Holder<Boolean> pendingVerification, Holder<String> verificationMeans) throws ServerException, ClientException {

        IAMIdentityManagementService iamIdentityManagementService = new IAMIdentityManagementService(getWdslUrl());
        IdentityManagementPort identityManagementPort = iamIdentityManagementService.getIdentityManagement();
        identityManagementPort.authenticateUser(user, password, userRole, additionalCredentials, userId, pendingVerification, verificationMeans);

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

    private URL getWdslUrl() {
        try {
            //http://gal-bss.ottcert.gvp.telefonica.com:8080/Service/TD_RegistrationService?wsdl
            return new URL(this.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
