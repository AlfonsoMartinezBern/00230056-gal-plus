package com.telefonica.gal.interfaceWs.wsGvp;

import com.telefonica.gal.wsdl.southbound.gvp.ITDRegistrationService;
import com.telefonica.gal.wsdl.southbound.gvp.RegistrationSoapService;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfboolean;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class    WsITDregistrationFactoryService implements ITDRegistrationService {
    private String url;

    public void setURL(String url) {
        this.url = url;
    }

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
        ResultDataContractOfstring result = itdRegistrationService.createUser(instanceId, platformId, user);

        return result;
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
            return new URL(this.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
