package com.telefonica.gal.client.spain.td.error.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;

@Service
public class Spain_TD_Error_Client implements ISpainTDError {
    @Value("${error.uri}")
    private String URI;

    public ErrorResponse search(ErrorKey errorKey) {
        String errorURL =
                URI
                        + "/search?operationApi=" + errorKey.getOperationApi() +
                        "&serviceApi=" + errorKey.getServiceApi() +
                        "&errorCode=" + errorKey.getErrorCode() +
                        "&errorCodeInterface=" + errorKey.getErrorCodeInterface() +
                        "&errorCodeOperation=" + errorKey.getErrorCodeOperation();

        RestTemplate plantilla = new RestTemplate();

        return plantilla.getForObject(errorURL, ErrorResponse.class);
        
    }
    
    


}
