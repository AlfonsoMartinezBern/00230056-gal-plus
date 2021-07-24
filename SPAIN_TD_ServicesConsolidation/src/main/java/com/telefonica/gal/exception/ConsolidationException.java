package com.telefonica.gal.exception;

import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;

public class ConsolidationException {

    private Spain_TD_Error_Client iSpainTDError;

    public ErrorMessage getErrorInfo(String errorMsg, String userId, String operationId) {
        ErrorKey errorKey = new ErrorKey(errorMsg);
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(errorKey);

        errorMessage.setMessage(errorResponse.getErrorInfo().getErrorDescription());
        errorMessage.setCodError(errorResponse.getErrorInfo().getErrorCode());
        errorMessage.setOperationid(operationId);
        errorMessage.setUserid(userId);

        return errorMessage;
    }

    public ErrorMessage getErrorInfoListService(String errorMsg, String service, String userId, String operationId) {
        ErrorKey errorKey = new ErrorKey(errorMsg);
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(errorKey);

        errorMessage.setMessage(errorResponse.getErrorInfo().getErrorDescription() + "" + service);
        errorMessage.setCodError(errorResponse.getErrorInfo().getErrorCode());
        errorMessage.setOperationid(operationId);
        errorMessage.setUserid(userId);

        return errorMessage;
    }
}
