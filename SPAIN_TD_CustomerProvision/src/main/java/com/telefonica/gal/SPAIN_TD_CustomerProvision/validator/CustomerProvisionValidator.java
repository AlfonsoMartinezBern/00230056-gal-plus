package com.telefonica.gal.SPAIN_TD_CustomerProvision.validator;


import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.CustomerException;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.utils.ErrorCodeEnum;
import com.telefonica.gal.customerProvision.request.*;

public class CustomerProvisionValidator {
    public void isValid(CUSTOMERPROVISIONREQUEST servicesconsolidationresponse) throws ErrorMessage {
        int result;
        for (CUSTOMER customer : servicesconsolidationresponse.getCUSTOMERS().getCUSTOMER()) {
            isValid(customer);
        }
    }

    public void isValid(CUSTOMER customer) throws ErrorMessage {

        String userId = customer.getUSERID();
        String operationId = customer.getOPERATIONID();

        // USER_ID
        if (customer.getUSERID().isEmpty() || customer.getUSERID().isBlank() || customer.getUSERID() == null)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_USER_ID.getValue() , userId, operationId);
        if (!customer.getUSERID().matches("^\\p{ASCII}*$") || customer.getUSERID().length() > 32)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_USER_ID.getValue(), userId, operationId);

        // OPERATION_TYPE
        if (customer.getOPERATIONTYPE().isEmpty() || customer.getOPERATIONTYPE().isBlank() || customer.getOPERATIONTYPE() == null)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_TYPE.getValue(), userId, operationId);
        if (!customer.getOPERATIONTYPE().equals("ON") && !customer.getOPERATIONTYPE().equals("MOD") && !customer.getOPERATIONTYPE().equals("OFF")
                && !customer.getOPERATIONTYPE().equals("N") && !customer.getOPERATIONTYPE().equals("D") && !customer.getOPERATIONTYPE().equals("NN") && !customer.getOPERATIONTYPE().equals("ND"))
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_TYPE.getValue(), userId, operationId);

        // GEOGRAFIC_AREA
        if (customer.getGEOGRAFICAREA() == 0) throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_GEOGRAFIC_AREA.getValue(), userId, operationId);
        if (String.valueOf(customer.getGEOGRAFICAREA()).length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_GEOGRAFIC_AREA.getValue(), userId, operationId);

        // USER_TYPE
        if (customer.getUSERTYPE().isEmpty() || customer.getUSERTYPE().isBlank() || customer.getUSERTYPE() == null)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_USER_TYPE.getValue(), userId, operationId);
        if (!customer.getUSERTYPE().equals("RESIDENTIAL") && !customer.getUSERTYPE().equals("BUSINESS") && !customer.getUSERTYPE().equals("OTT"))
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_USER_TYPE.getValue(), userId, operationId);

        // SERVICE_TYPE
        if (customer.getSERVICETYPE().isEmpty() || customer.getSERVICETYPE().isBlank() || customer.getSERVICETYPE() == null)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_SERVICE_TYPE.getValue(), userId, operationId);
        if (customer.getSERVICETYPE().length() > 32)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SERVICE_TYPE.getValue(), userId, operationId);

        //STB_IP
        for (String ip : customer.getLISTSTBIPS().getSTBIP()) {
            if (ip.isEmpty() || ip.isBlank() || ip == null)
                throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_DEVICE.getValue(), userId, operationId);
            if (ip.length() > 15) throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_DEVICE.getValue(), userId, operationId);
        }

        // TV_SERVICE_ID
        if (customer.getLISTTVSERVICES() != null) {
            if (customer.getLISTTVSERVICES().getTVSERVICE() != null) {
                for (TVSERVICE tvservice : customer.getLISTTVSERVICES().getTVSERVICE()) {
                    String serviceID = tvservice.getTVSERVICEID();
                    String serviceOP = tvservice.getTVSERVICEOPER().value();
                    if (serviceID.isBlank() || serviceID.isEmpty() || serviceID == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_ID.getValue(), userId, operationId);
                    if (!serviceID.matches("^\\p{ASCII}*$") || serviceID.length() > 32)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(), userId, operationId);

                    // TV_SERVICE_OPER si TV_SERVICE_ID presente
                    if (tvservice.getTVSERVICEOPER() == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_PACKACGE_OPERATION.getValue(), userId, operationId);
                    if (!serviceOP.equals("ON") && !serviceOP.equals("OFF") && !serviceOP.equals("KEEP"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(), userId, operationId);
                }
            }
        }

        // POP
        if (customer.getPOP() == 0)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_POP.getValue(), userId, operationId);
        if (String.valueOf(customer.getPOP()).length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_POP.getValue(), userId, operationId);

        // SUBSCRIBER_LINE_UPSTREAM
        if (customer.getSUBSCRIBERLINE().getUPSTREAM() == 0)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_SUSCRIBER_LINE_UPSTREAM.getValue(), userId, operationId);
        if (String.valueOf(customer.getSUBSCRIBERLINE().getUPSTREAM()).length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SUSCRIBER_LINE_UPSTREAM.getValue(), userId, operationId);

        // SUBSCRIBER_LINE_DOWNSTREAM
        if (customer.getSUBSCRIBERLINE().getDOWNSTREAM() == 0)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_SUSCRIBER_LINE_DOWNSTREAM.getValue(), userId, operationId);
        if (String.valueOf(customer.getSUBSCRIBERLINE().getDOWNSTREAM()).length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SUSCRIBER_LINE_DOWNSTREAM.getValue(), userId, operationId);

        if (customer.getLISTVODSERVICES() != null) {
            if (customer.getLISTVODSERVICES().getVODSERVICE() != null) {
                for (VODSERVICE vodservice : customer.getLISTVODSERVICES().getVODSERVICE()) {
                    String vodServiceID = vodservice.getVODSERVICEID();
                    String vodServiceOp = vodservice.getVODSERVICEOPER().value();

                    // VOD_SERVICE_ID, si LIST_VOD_SERVICE presente
                    if (vodServiceID.isBlank() || vodServiceID.isEmpty() || vodServiceID == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_VOD_SERVICE_ID.getValue(), userId, operationId);
                    if (!vodServiceID.matches("^\\p{ASCII}*$") || vodServiceID.length() > 32)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_ID.getValue(), userId, operationId);

                    //VOD_SERVICE_OPER si VOD_SERVICE_ID presente
                    if (vodServiceOp.isBlank() || vodServiceOp.isEmpty() || vodServiceOp == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_OPER.getValue(), userId, operationId);
                    if (!vodServiceOp.equals("ON") && !vodServiceOp.equals("OFF") && !vodServiceOp.equals("KEEP"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), userId, operationId);

                }
            }
        }
        if (customer.getLISTOPERATORBONUS() != null) {
            if (customer.getLISTOPERATORBONUS().getOPERATORBONUS() != null) {
                for (OPERATORBONUS operatorbonus : customer.getLISTOPERATORBONUS().getOPERATORBONUS()) {
                    String operation = operatorbonus.getOperation().value();

                    // OPERATOR_BONUS si LIST_OPERATOR_BONUS presente
                    if (operatorbonus.getValue().isEmpty() || operatorbonus.getValue().isBlank() || operatorbonus.getValue() == null || operatorbonus == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATOR_BONUS.getValue(), userId, operationId);
                    if (operatorbonus.getValue().length() > 32)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_OPERATOR_BONUS.getValue(), userId, operationId);

                    // operation si LIST_OPERATOR_BONUS presente
                    if (operatorbonus.getOperation() == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_OPERATOR_BONUS.getValue(), userId, operationId);
                    if (!operation.equals("ON") && !operation.equals("OFF") && !operation.equals("KEEP"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_OPERATOR_BONUS.getValue(), userId, operationId);

                }
            }
        }

        // ADDRESSING (solo debe comprobarse el formato)
        if (customer.getADDRESSING() != null && !customer.getADDRESSING().equals("STATIC_IP") && !customer.getADDRESSING().equals("STATIC_IP_NAT") && !customer.getADDRESSING().equals("DYNAMIC_IP") && !customer.getADDRESSING().equals("DYNAMIC_IP_MAC"))
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_ADDRESSING.getValue(), userId, operationId);

        // MAX_NUM_STBS (solo debe comprobarse el formato)
        if (customer.getMAXNUMSTBS() > 99)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_MAX_NUM_STBS.getValue(), userId, operationId);
    }

}
