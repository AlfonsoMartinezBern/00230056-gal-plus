package com.telefonica.gal.client.spain.td.error.facade;

import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telefonica.gal.client.spain.td.error.msg.ErrorInfo;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;

@Service
public class Spain_TD_Error_Client implements ISpainTDError {
    @Value("${local.error.uri}")
    private String URI;

    public ErrorResponse search(ErrorKey errorKey) {
        String errorURL =
                URI
                        + "/search?errorCode=" + errorKey.getErrorCode();

        RestTemplate plantilla = new RestTemplate();

        return plantilla.getForObject(errorURL, ErrorResponse.class);
        
//        return mockSearch(errorKey);
    }

}
