package com.telefonica.gal.mapper;

import com.telefonica.gal.wsdl.northbound.provManagement.ExtensionType;

import javax.xml.bind.annotation.XmlElement;

public class DeviceAdditionalCredentials extends ExtensionType {

    @XmlElement(namespace = "http://www.telefonica.com/wsdl/UNICA/SOAP/IAM_IdentityManagement/v2/local")
    protected String deviceMacAddress;
    @XmlElement(namespace = "http://www.telefonica.com/wsdl/UNICA/SOAP/IAM_IdentityManagement/v2/local")
    protected String deviceGUID;

    public String getDeviceMacAddress() {
        return deviceMacAddress;
    }

    public void setDeviceMacAddress(String deviceMacAddress) {
        this.deviceMacAddress = deviceMacAddress;
    }

    public String getDeviceGUID() {
        return deviceGUID;
    }

    public void setDeviceGUID(String deviceGUID) {
        this.deviceGUID = deviceGUID;
    }
}
