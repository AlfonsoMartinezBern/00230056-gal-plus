package com.telefonica.gal.response;

import com.telefonica.gal.client.spain.td.error.facade.ISpainTDError;
import com.telefonica.gal.client.spain.td.error.msg.ErrorInfo;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.servicesConsolidation.response.CUSTOMER;
import com.telefonica.gal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public class ResponseWs implements IResponseWs {
    private ISpainTDError iSpainTDError;

    @Autowired
    private ResponseWs(ISpainTDError iSpainTDError) {
        this.iSpainTDError = iSpainTDError;
    }

    @Override
    public CUSTOMER responseInfo(ResponseEntity<Object> objectResponseEntity, String codeInterface, String codeOperation) {
        com.telefonica.gal.servicesConsolidation.response.CUSTOMER responseCustomer = new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();
        ErrorKey errorKey = new ErrorKey(Utils.ServicesConsolidation.getOperation(),
                objectResponseEntity.getStatusCode().toString(),
                codeInterface,
                codeOperation);

        ErrorInfo errorInfo= iSpainTDError.search(errorKey);

        responseCustomer.setRESULTCODE(new BigInteger(errorInfo.getErrorCode()));
        responseCustomer.setDESCRIPTION(errorInfo.getErrorDescription());


        return responseCustomer;
    }
}

