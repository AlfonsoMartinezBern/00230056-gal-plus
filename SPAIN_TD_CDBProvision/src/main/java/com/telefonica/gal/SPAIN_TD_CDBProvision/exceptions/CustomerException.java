package com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions;

import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;

public class CustomerException {

    private Spain_TD_Error_Client iSpainTDError;

    public ErrorMessage getErrorInfo (String errorMsg, String userId, String operationId) {
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(new ErrorKey(errorMsg));

        errorMessage.setMessage(errorResponse.getErrorInfo().getErrorDescription());
        errorMessage.setCodError(errorResponse.getErrorInfo().getErrorCode());
        errorMessage.setOperationid(operationId == null ? "" : operationId);
        errorMessage.setUserid(userId);

        return errorMessage;
    }

    public ErrorMessage getErrorInfoListService (String errorMsg, String service, String userId, String operationId) {
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(new ErrorKey(errorMsg));

        errorMessage.setMessage(errorResponse.getErrorInfo().getErrorDescription() + service);
        errorMessage.setCodError(errorResponse.getErrorInfo().getErrorCode());
        errorMessage.setOperationid(operationId);
        errorMessage.setUserid(userId);

        return errorMessage;
    }
}
