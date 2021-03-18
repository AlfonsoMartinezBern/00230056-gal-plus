package com.telefonica.gal.ws.userManagement;

import com.telefonica.gal.wsdl.southbound.gvp.ITDRegistrationService;
import com.telefonica.gal.wsdl.southbound.gvp.RegistrationSoapService;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfboolean;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class WsITDregistrationService implements ITDRegistrationService {
    @Override
    public ResultDataContractOfboolean enableUser(int instanceId, int platformId, UserDataContract user) {
        return null;
    }

    @Override
    public ResultDataContractOfboolean disableUser(int instanceId, int platformId, String uniqueId, String reason) {
        return null;
    }

    @Override
    public ResultDataContractOfstring createUser(int instanceId, int platformId, UserDataContract user) {
        RegistrationSoapService registrationSoapService = new RegistrationSoapService(getWdslUrl());

        ITDRegistrationService itdRegistrationService = registrationSoapService.getBasicHttpBindingITDRegistrationService();

        itdRegistrationService.createUser(instanceId,platformId,user);

        return null;
    }

    @Override
    public ResultDataContractOfboolean deleteUser(int instanceId, int platformId, String uniqueId, String newUniqueId, String reason) {
        return null;
    }

    @Override
    public ResultDataContractOfboolean modifyUser(int instanceId, int platformId, UserDataContract user) {
        return null;
    }

    private URL getWdslUrl() {
        try {
            //http://gal-bss.ottcert.gvp.telefonica.com:8080/Service/TD_RegistrationService?wsdl
            return new URL("http://localhost:20100/GVP_TD_RegistrationService?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
