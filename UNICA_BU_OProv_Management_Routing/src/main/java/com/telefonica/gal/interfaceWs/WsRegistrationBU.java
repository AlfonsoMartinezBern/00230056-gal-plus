package com.telefonica.gal.interfaceWs;

import com.telefonica.gal.mapper.XQRegistrationServiceRequest;
import com.telefonica.gal.mapper.XQRegistrationServiceResponse;
import com.telefonica.gal.mapper.XQRegistrationServiceResponseFAULT;
import com.telefonica.gal.wsdl.northbound.provManagement.AuthenticateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.ClientException;
import com.telefonica.gal.wsdl.northbound.provManagement.ServerException;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDevice;
import com.telefonica.gal.wsdl.southbound.registrationservice.GetAccountForDeviceResponse;
import org.mapstruct.factory.Mappers;

import javax.xml.ws.Holder;

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
        try {
            response = invokeAuthenticateUser(getAccountForDevice);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }

    private T invokeAuthenticateUser(T getAccountForDevice) throws ServerException, ClientException {
        AuthenticateUser authenticateUser = XQ_REGISTRATION_SERVICE_REQUEST.getAccountForDeviceToAuthenticateUser(
                (GetAccountForDevice) getAccountForDevice);

        wsRegistrationService.setURL("URL");

        //TODO validar los parámetros userId,  pendingVerification,verificationMeans, luego invocar WS de Auth
        wsRegistrationService.authenticateUser(authenticateUser.getUser(), authenticateUser.getPassword(),authenticateUser.getUserRole(),
                authenticateUser.getAdditionalCredentials(), new Holder<>(authenticateUser.getUser()), new Holder<>(true), new Holder<>("verificationMeans") );

        GetAccountForDeviceResponse getAccountForDeviceResponse = XQ_REGISTRATION_SERVICE_RESPONSE_FAULT
                .getAccountForDeviceResponseTo("OK");

        return (T) getAccountForDeviceResponse;
    }

}
