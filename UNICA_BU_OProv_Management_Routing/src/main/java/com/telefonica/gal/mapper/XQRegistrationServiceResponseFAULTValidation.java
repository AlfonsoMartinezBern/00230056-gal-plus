package com.telefonica.gal.mapper;

import com.telefonica.gal.dto.GalErrorCollection;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDeviceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface XQRegistrationServiceResponseFAULTValidation {
    @Mapping(target = "GetAccountForDeviceResult.statusCode", expression = "java(lookUpStatusCode(galErrorCollection.getError()))")
    @Mapping(target = "GetAccountForDeviceResult.severity", constant = "Error")
    @Mapping(target = "getAccountForDeviceResult.statusMessage", source = "galErrorCollection.message")
    @Mapping(target = "GetAccountForDeviceResult.content", ignore = true)
    GetAccountForDeviceResponse getAccountForDeviceResponseTo (GalErrorCollection galErrorCollection);

    default String lookUpStatusCode(final String statusCode) {
        final String usernotauthorized = "Usernotauthorized";
        final String internalservererroringSDP = "InternalservererroringSDP_D26";
        final String internalservererrorinOBsystem = "InternalservererrorinOBsystem";
        final String otherAuthenticationError = "OtherAuthenticationError";
        final String invalidInstanceId = "invalidInstanceId";
        String status = "";

        if (statusCode.contains("User not Authorized")) {
            status = usernotauthorized;
        } else if (statusCode.contains("Internal Server Error in gSDP")) {
            status = internalservererroringSDP;
        } else if (status.contains("Internal Server Error in OB")) {
            status =internalservererrorinOBsystem;
        } else if (status.contains("Other Authentication Error")) {
            status = otherAuthenticationError;
        } else if (statusCode.equals("Invalid Instance Id")) {
            status = invalidInstanceId;
        } else {
            status = statusCode;
        }

        return status;
    }

}
