package com.telefonica.gal.mapper.registrationBU;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;

import javax.xml.bind.annotation.XmlElement;

public class AuthenticateUserExtends extends AuthenticateUser {

    @XmlElement(namespace = "http://www.telefonica.com/wsdl/UNICA/SOAP/IAM_IdentityManagement/v2/local")
    protected DeviceAdditionalCredentials deviceAdditionalCredentials;

    public AuthenticateUserExtends() {
    }

    public DeviceAdditionalCredentials getDeviceAdditionalCredentials() {
        return deviceAdditionalCredentials;
    }

    public void setDeviceAdditionalCredentials(DeviceAdditionalCredentials deviceAdditionalCredentials) {
        this.deviceAdditionalCredentials = deviceAdditionalCredentials;
    }
}
