package com.telefonica.gal.transform;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUserResponse;
import com.telefonica.gal.wsdl.southbound.registration.GetAccountForDeviceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface AuthenticateUserRequestMapper {

    @Mapping(source = "GetAccountForDeviceResultType.", target = "userId")
    @Mapping(source = "GetAccountForDeviceResultType.", target = "pendingVerification")
    @Mapping(source = "GetAccountForDeviceResultType.", target = "verificationMeans")
    GetAccountForDeviceResponse AccountData_Mapper(AuthenticateUserResponse authenticateUser);

}
