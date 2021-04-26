package com.telefonica.gal.mapper;

import com.telefonica.gal.mapper.registrationBU.XQRegistrationServiceRequest;
import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDevice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class XQRegistrationServiceRequestTest {
    private XQRegistrationServiceRequest xqRegistrationServiceRequest = Mappers.getMapper(
            XQRegistrationServiceRequest.class);
    private AuthenticateUser authenticateUser = new AuthenticateUser();

    @Test
    public void testRegistrationServiceRequest() {
        //Caso registrationId es 1
        GetAccountForDevice getAccountForDevice = new GetAccountForDevice();
        getAccountForDevice.setRegistrationId(1);
        getAccountForDevice.setIP("IP");
        getAccountForDevice.setGUID("GUID");

        authenticateUser = xqRegistrationServiceRequest.getAccountForDeviceToAuthenticateUser(
                getAccountForDevice);

        Assertions.assertEquals("IP" , authenticateUser.getUser().getIpAddress().getIpv4());
        Assertions.assertEquals(1 , authenticateUser.getPassword());

    }
}
