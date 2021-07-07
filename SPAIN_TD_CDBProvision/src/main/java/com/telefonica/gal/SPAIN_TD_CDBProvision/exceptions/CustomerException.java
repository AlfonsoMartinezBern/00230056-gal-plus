package com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions;

import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;

public class CustomerException {

    private Spain_TD_Error_Client iSpainTDError;

    public ErrorMessage getErrorInfo(Integer resultCode, String errorMsg, String text) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setResultCode(resultCode);
        errorMessage.setResultDetail(errorMsg);
        errorMessage.setResultText(text);
        return errorMessage;
    }
}
