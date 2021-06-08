package com.telefonica.gal.validate;

import com.telefonica.gal.exception.ConsolidationException;
import com.telefonica.gal.exception.ErrorMessage;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.LISTTVSERVICES;
import com.telefonica.gal.servicesConsolidation.request.OperationType;
import com.telefonica.gal.servicesConsolidation.request.TVSERVICE;
import com.telefonica.gal.servicesConsolidation.request.VODSERVICE;
import com.telefonica.gal.utils.ErrorCodeEnum;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
public class ValidateConsolidation  {

    public static void validateRequest(CUSTOMER request) throws ErrorMessage {
        /*Formato y presencia de:
        TV_SERVICE_ID, si LIST_TV_SERVICE presente == > Alphanumerical longitud 32
        TV_SERVICE_OPER si TV_SERVICE_ID presente  == > TV_SERVICE_OPER sólo ON’ | ‘OFF’ | ‘KEEP’
        VOD_SERVICE_ID, si LIST_VOD_SERVICE presente == > Alphanumerical longitud 32
        VOD_SERVICE_OPER si VOD_SERVICE_ID presente*/// == > TV_SERVICE_OPER sólo ON’ | ‘OFF’ | ‘KEEP’

        //Comprobar si está vacio el OPERATION_ID

        if (request.getOPERATIONID() == null) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_ID.getValue());
        }


        if (request.getOPERATIONID().isEmpty() || request.getOPERATIONID().length() > 11) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_ID.getValue());
        }

        //Comprobar USER_ID
        if (request.getUSERID() == null) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_USER_ID.getValue());
        }

        if (request.getUSERID().isEmpty() || request.getUSERID().length() > 32) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_USER_ID.getValue());
        }

        //LIST_TV_SERVICE

        if (request.getLISTTVSERVICES() != null) {

            for (TVSERVICE tvservice : request.getLISTTVSERVICES().getTVSERVICE()) {
                if (tvservice.getTVSERVICEID() == null) {
                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_ID.getValue());

                }

                if (tvservice.getTVSERVICEID().isEmpty() || tvservice.getTVSERVICEID().length() > 32) {
                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue());

                }

                //Falta validar la  operacion

            }
        }

    }

}
