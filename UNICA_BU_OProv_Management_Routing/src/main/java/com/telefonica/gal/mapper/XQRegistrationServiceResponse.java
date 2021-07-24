package com.telefonica.gal.mapper;

import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUserResponse;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDeviceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface XQRegistrationServiceResponse {
    @Mapping(target = "GetAccountForDeviceResult.statusCode", constant = "OK")
    @Mapping(target = "GetAccountForDeviceResult.severity", constant = "Info")
    @Mapping(target = "GetAccountForDeviceResult.statusMessage", constant = "OK")
    @Mapping(target = "getAccountForDeviceResult.content.uniqueId", source = "response.userId.alias")
    GetAccountForDeviceResponse getAccountForDeviceResponseTo(AuthenticateUserResponse response);
}
