package com.telefonica.gal.mapper;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDevice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class XQRegistrationServiceRequestTest {
    private XQRegistrationServiceRequest xqRegistrationServiceRequest = Mappers.getMapper(
            XQRegistrationServiceRequest.class);
    private AuthenticateUser authenticateUser = new AuthenticateUser();

    @Test
    public void testDeviceAdditionalCredentialsRequest() {

        GetAccountForDevice getAccountForDevice = new GetAccountForDevice();
        getAccountForDevice.setRegistrationId(12);
        getAccountForDevice.setIP("IP");
        getAccountForDevice.setMAC("MAC");
        getAccountForDevice.setGUID("GUID");

        authenticateUser = xqRegistrationServiceRequest.getAccountForDeviceToAuthenticateUser(
                getAccountForDevice);

        Assertions.assertEquals("IP" , authenticateUser.getUser().getIpAddress().getIpv4());
        Assertions.assertEquals("DUMMY" , authenticateUser.getPassword());

    }
}
