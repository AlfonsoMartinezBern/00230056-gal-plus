package com.telefonica.gal.mapper;

import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDeviceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface XQRegistrationServiceResponseFAULT {
    @Mapping(target = "GetAccountForDeviceResult.statusCode", expression = "java(lookUpStatusCode(error))")
    @Mapping(target = "GetAccountForDeviceResult.severity", constant = "Error")
    @Mapping(target = "GetAccountForDeviceResult.StatusMessage", expression = "java(lookUpStatusMessage(error))")
    @Mapping(target = "getAccountForDeviceResult.content", ignore = true)
    GetAccountForDeviceResponse getAccountForDeviceResponseTo (String error);


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

    default String lookUpStatusMessage(final String errorType, final String errorNative, final String other) {
        String error = "";
        if (errorType.contains("SVC") || (other.contains("CannotconnecttogSDP"))) {
            error = errorNative;
        } else {
            error = other;
        }
        return error;
    }
}
