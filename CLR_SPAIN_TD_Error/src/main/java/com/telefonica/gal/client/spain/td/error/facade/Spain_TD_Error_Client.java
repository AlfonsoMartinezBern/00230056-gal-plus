package com.telefonica.gal.client.spain.td.error.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telefonica.gal.client.spain.td.error.msg.ErrorInfo;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;

@Service
public class Spain_TD_Error_Client implements ISpainTDError {
    @Value("${error.uri}")
    private String URI;

    public ErrorInfo search(ErrorKey errorKey) {
        String errorURL =
                URI
                        + "/search?operationApi=" + errorKey.getOperationApi() +
                        "/search?serviceApi=" + errorKey.getServiceApi() +
                        "&errorCode=" + errorKey.getErrorCode() +
                        "&errorCodeInterface=" + errorKey.getErrorCodeInterface() +
                        "&errorCodeOperation=" + errorKey.getErrorCodeOperation();

        RestTemplate plantilla = new RestTemplate();

        return plantilla.getForObject(errorURL, ErrorInfo.class);
        
//        return mockSearch(errorKey);
    }
    
    
    
    
    private ErrorInfo mockSearch(ErrorKey errorKey) {
    	
    	return new ErrorInfo(errorKey.getErrorCode(),"Descripcion del error para: " +errorKey.getErrorCode()+
    			" errorCodeOperation=" + errorKey.getErrorCodeOperation() +
                " errorCodeInterface=" + errorKey.getErrorCodeInterface() +
                " serviceApi=" + errorKey.getServiceApi() +
                " operationApi=" + errorKey.getOperationApi());
    }

}
