package com.telefonica.gal.wsRouting.wsUmg;

import com.telefonica.serviceid.ServiceIdType;
import gal.gvp.ITDRegistrationService;
import gal.gvp.RemoveDevicesFromAccountRequestBody;
import gal.gvp.RemoveDevicesFromAccountResponseBody;
import org.datacontract.schemas._2004._07.gvp_gal.DeviceInfoListType;
import org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfboolean;
import org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfstring;
import org.datacontract.schemas._2004._07.gvp_gal.UserDataContract;
import org.springframework.stereotype.Service;
import org.tempuri.TDRegistrationService;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class WsITDregistrationFactoryUMG implements ITDRegistrationService {

    private String url;

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public ResultDataContractOfboolean registerDevices(Integer instanceId, Integer platformId, ServiceIdType serviceId, String uniqueId, DeviceInfoListType deviceInfoList) {
        return null;
    }

    @Override
    public ResultDataContractOfstring createUser(Integer instanceId, Integer platformId, ServiceIdType serviceId, UserDataContract user) {
        TDRegistrationService registrationSoapService = new TDRegistrationService(getWdslUrl());
        ITDRegistrationService itdRegistrationService = registrationSoapService.getBasicHttpBindingITDRegistrationService();
        ResultDataContractOfstring result = itdRegistrationService.createUser(instanceId, platformId, user.getServiceId(), user);

        return result;
    }

    @Override
    public ResultDataContractOfboolean deleteUser(Integer instanceId, Integer platformId, ServiceIdType serviceId, String uniqueId, String reason) {
        return null;
    }

    @Override
    public ResultDataContractOfboolean enableUser(Integer instanceId, Integer platformId, ServiceIdType serviceId, UserDataContract user) {
        return null;
    }

    @Override
    public RemoveDevicesFromAccountResponseBody removeDevicesFromAccount(RemoveDevicesFromAccountRequestBody removeDevicesFromAccount) {
        return null;
    }

    @Override
    public ResultDataContractOfboolean disableUser(Integer instanceId, Integer platformId, ServiceIdType serviceId, String uniqueId, String reason) {
        return null;
    }

    @Override
    public ResultDataContractOfboolean removeDevices(Integer instanceId, Integer platformId, ServiceIdType serviceId, String uniqueId, DeviceInfoListType deviceInfoList) {
        return null;
    }

    @Override
    public ResultDataContractOfboolean modifyUser(Integer instanceId, Integer platformId, ServiceIdType serviceId, UserDataContract user) {
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
