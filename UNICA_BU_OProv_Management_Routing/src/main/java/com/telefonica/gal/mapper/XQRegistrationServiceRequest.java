package com.telefonica.gal.mapper;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.ExtensionType;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDevice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface XQRegistrationServiceRequest {
    @Mapping(target = "user.ipAddress.ipv4", source = "getAccountForDevice.IP")
    @Mapping(target = "password", expression = "java(getPassword(getAccountForDevice))")
    @Mapping(target = "userRole", ignore = true)
    @Mapping(target = "additionalCredentials", expression = "java(getExtensionType(getAccountForDevice))" )
    AuthenticateUser getAccountForDeviceToAuthenticateUser(GetAccountForDevice getAccountForDevice);

   default String getPassword(final GetAccountForDevice getAccountForDevice) {
       String password = "";

       if (getAccountForDevice.getRegistrationId().equals(1)) {
           password = String.valueOf(getAccountForDevice.getRegistrationId());
       } else {
           password = "DUMMY";
       }
       return password;
   }

   default ExtensionType getExtensionType(final GetAccountForDevice getAccountForDevice) {
       DeviceAdditionalCredentials deviceAdditionalCredentials = new DeviceAdditionalCredentials();
       deviceAdditionalCredentials.setDeviceGUID(getAccountForDevice.getGUID());
       deviceAdditionalCredentials.setDeviceMacAddress(getAccountForDevice.getMAC());

       ExtensionType extensionType = deviceAdditionalCredentials;

       return extensionType;

   }

}
