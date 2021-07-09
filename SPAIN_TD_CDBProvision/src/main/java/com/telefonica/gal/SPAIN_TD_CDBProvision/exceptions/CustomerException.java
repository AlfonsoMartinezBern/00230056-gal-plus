package com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions;

import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerException {

    @Autowired
    private Spain_TD_Error_Client iSpainTDError;

    public ErrorMessage getErrorInfo(Integer resultCode, String errorMsg, String text) {
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(new ErrorKey(errorMsg));

        errorMessage.setResultCode(resultCode);
        errorMessage.setResultDetail(errorResponse.getErrorInfo().getErrorDescription());
        errorMessage.setResultText(errorResponse.getErrorInfo().getErrorCode());

        return errorMessage;
    }

}
