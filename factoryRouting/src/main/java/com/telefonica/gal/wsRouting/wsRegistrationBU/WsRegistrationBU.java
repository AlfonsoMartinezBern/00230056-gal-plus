package com.telefonica.gal.wsRouting.wsRegistrationBU;

import com.telefonica.gal.mapper.registrationBU.XQRegistrationServiceRequest;
import com.telefonica.gal.mapper.registrationBU.XQRegistrationServiceResponse;
import com.telefonica.gal.mapper.registrationBU.XQRegistrationServiceResponseFAULT;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDevice;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDeviceResponse;
import org.mapstruct.factory.Mappers;

public class WsRegistrationBU<T> implements InvokeWs {
    private final static XQRegistrationServiceRequest XQ_REGISTRATION_SERVICE_REQUEST = Mappers.getMapper(
            XQRegistrationServiceRequest.class);
    private final static XQRegistrationServiceResponse XQ_REGISTRATION_SERVICE_RESPONSE = Mappers.getMapper(
            XQRegistrationServiceResponse.class);
    private final static XQRegistrationServiceResponseFAULT XQ_REGISTRATION_SERVICE_RESPONSE_FAULT = Mappers.getMapper(
            XQRegistrationServiceResponseFAULT.class);

    WsRegistrationService wsRegistrationService = new WsRegistrationService();
    private T getAccountForDevice;
    private T response;

    public WsRegistrationBU(T getAccountForDevice) {
        this.getAccountForDevice = getAccountForDevice;
    }

    @Override
    public T invoke() {
        response = invokeAuthenticateUser(getAccountForDevice);
        return response;
    }

    private T invokeAuthenticateUser(T getAccountForDevice) {
        AuthenticateUser authenticateUser = XQ_REGISTRATION_SERVICE_REQUEST.getAccountForDeviceToAuthenticateUser(
                (GetAccountForDevice) getAccountForDevice);

        wsRegistrationService.setURL("URL");
        //TODO validar los parámetros userId,  pendingVerification,verificationMeans, luego invocar WS de Auth
        /*wsRegistrationService.authenticateUser(authenticateUser.getUser(), authenticateUser.getPassword(),authenticateUser.getUserRole(),
                authenticateUser.getAdditionalCredentials(), authenticateUser.getUser(), true, "verificationMeans" );*/

        GetAccountForDeviceResponse getAccountForDeviceResponse = XQ_REGISTRATION_SERVICE_RESPONSE_FAULT
                .getAccountForDeviceResponseTo("OK");


        return (T) getAccountForDeviceResponse;
    }

}
