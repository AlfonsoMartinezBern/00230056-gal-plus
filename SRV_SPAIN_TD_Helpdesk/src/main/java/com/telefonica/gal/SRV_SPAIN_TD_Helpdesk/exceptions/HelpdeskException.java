package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.exceptions;


import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;

public class HelpdeskException {

    private Spain_TD_Error_Client iSpainTDError;

    public ErrorMessage getErrorInfo (String errorMsg, String orden_hidra) {
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(new ErrorKey(errorMsg));

        errorMessage.setMessage(errorResponse.getErrorInfo().getErrorDescription());
        errorMessage.setCodError(errorResponse.getErrorInfo().getErrorCode());
        errorMessage.setOrden_hidra(orden_hidra);

        return errorMessage;
    }

    public ErrorMessage getErrorInfoListService (String errorMsg, String service, String orden_hidra) {
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorMessage errorMessage = new ErrorMessage();
        ErrorResponse errorResponse = iSpainTDError.search(new ErrorKey(errorMsg));

        errorMessage.setMessage(errorResponse.getErrorInfo().getErrorDescription() + service);
        errorMessage.setCodError(errorResponse.getErrorInfo().getErrorCode());
        errorMessage.setOrden_hidra(orden_hidra);

        return errorMessage;
    }
}
