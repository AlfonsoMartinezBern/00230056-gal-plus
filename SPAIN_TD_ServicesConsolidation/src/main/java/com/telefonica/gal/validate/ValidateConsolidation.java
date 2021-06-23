package com.telefonica.gal.validate;

import com.telefonica.gal.exception.ConsolidationException;
import com.telefonica.gal.exception.ErrorMessage;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.request.TVSERVICE;
import com.telefonica.gal.servicesConsolidation.request.VODSERVICE;
import com.telefonica.gal.utils.ErrorCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class ValidateConsolidation  {

    public void isValid(SERVICESCONSOLIDATIONREQUEST servicesconsolidationrequest) throws ErrorMessage {
        for (CUSTOMER customer : servicesconsolidationrequest.getCUSTOMERS().getCUSTOMER()) {
            isValid(customer);
        }
    }

    public static void isValid(CUSTOMER request) throws ErrorMessage {

        String userId = request.getUSERID();
        String operationId = request.getOPERATIONID();


        if (request.getOPERATIONID() == null || request.getOPERATIONID().isEmpty()) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_ID.getValue(), userId, "");
        }


        if (request.getOPERATIONID().length() > 11) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_ID.getValue(), userId, operationId);
        }


        if (request.getUSERID() == null || request.getUSERID().isEmpty()) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_USER_ID.getValue(), "", operationId);
        }

        if (request.getUSERID().length() > 32) {
            throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_USER_ID.getValue(), userId, operationId);
        }



        if (request.getLISTTVSERVICES() != null) {

            for (TVSERVICE tvservice : request.getLISTTVSERVICES().getTVSERVICE()) {
                if (tvservice.getTVSERVICEID() == null || tvservice.getTVSERVICEID().isEmpty()) {
                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_ID.getValue(), userId, operationId);

                }

                if (tvservice.getTVSERVICEID().length() > 32) {

                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(), userId, operationId);

                    /*throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(),
                                                                    tvservice.getTVSERVICEID());*/

                } else {
                   if( tvservice.getTVSERVICEOPER() == null) {
                       throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_OPER.getValue(), userId, operationId);
                       /*throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(),
                                                                        tvservice.getTVSERVICEOPER().toString());*/
                   }
                }
            }
        }


        if (request.getLISTVODSERVICES() != null) {
            for (VODSERVICE vodservice : request.getLISTVODSERVICES().getVODSERVICE()) {
                if (vodservice.getVODSERVICEID() == null || vodservice.getVODSERVICEID().isEmpty()) {
                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_VOD_SERVICE_ID.getValue(), userId, operationId);

                }

                if ( vodservice.getVODSERVICEID().length() > 32) {
                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_ID.getValue(), userId, operationId);

                    /*throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_ID.getValue(),
                            vodservice.getVODSERVICEID());*/

                } else {
                    if( vodservice.getVODSERVICEOPER() == null) {
                        throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_VOD_SERVICE_ID.getValue(), userId, operationId);

                        /*throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(),
                                vodservice.getVODSERVICEOPER().toString());*/
                    }
                }

            }

        }

    }

}
