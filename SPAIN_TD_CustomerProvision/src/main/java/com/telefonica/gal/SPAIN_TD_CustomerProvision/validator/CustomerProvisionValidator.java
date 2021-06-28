package com.telefonica.gal.SPAIN_TD_CustomerProvision.validator;


import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.CustomerException;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.utils.ErrorCodeEnum;
import com.telefonica.gal.customerProvision.request.*;
import com.telefonica.gal.dto.customer.Customer;
import com.telefonica.gal.dto.customer.CustomerProvisionRequest;
import com.telefonica.gal.dto.customer.TvService;
import com.telefonica.gal.dto.customer.VodService;

public class CustomerProvisionValidator {

    public void isValid(CustomerProvisionRequest servicesconsolidationresponse) throws ErrorMessage {
        int result;
        for (com.telefonica.gal.dto.customer.Customer customer : servicesconsolidationresponse.getCustomers().getCustomer()) {
            isValid(customer);
        }
    }

    public void isValid(Customer customer) throws ErrorMessage {

        String userId = customer.getUserid();
        String operationId = customer.getOperationid();

        // USER_ID
        //if (customer.getUSERID().isEmpty() || customer.getUSERID().isBlank() || customer.getUSERID() == null)
        if (customer.getUserid() == null || customer.getUserid().isEmpty() || customer.getUserid().isBlank() )
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_USER_ID.getValue() , "", operationId);
        if (!customer.getUserid().matches("^\\p{ASCII}*$") || customer.getUserid().length() > 32)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_USER_ID.getValue(), userId, operationId);
        // OPERATION_TYPE
        if (customer.getOperationtype() == null || customer.getOperationtype().isEmpty() || customer.getOperationtype().isBlank())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_TYPE.getValue(), userId, operationId);
        if (!customer.getOperationtype().equals("ON") && !customer.getOperationtype().equals("MOD") && !customer.getOperationtype().equals("OFF")
                && !customer.getOperationtype().equals("N") && !customer.getOperationtype().equals("D") && !customer.getOperationtype().equals("NN") && !customer.getOperationtype().equals("ND"))
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_TYPE.getValue(), userId, operationId);

        // GEOGRAFIC_AREA
        if (customer.getGeograficarea() == null || customer.getGeograficarea().isEmpty() || customer.getGeograficarea().isBlank())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_GEOGRAFIC_AREA.getValue(), userId, operationId);
        if (customer.getGeograficarea().length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_GEOGRAFIC_AREA.getValue(), userId, operationId);
        boolean isNumeric =  customer.getGeograficarea().matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNumeric) throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_GEOGRAFIC_AREA.getValue(), userId, operationId);

        // USER_TYPE
        if (customer.getUsertype() == null || customer.getUsertype().isEmpty() || customer.getUsertype().isBlank())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_USER_TYPE.getValue(), userId, operationId);
        if (!customer.getUsertype().equals("RESIDENTIAL") && !customer.getUsertype().equals("BUSINESS") && !customer.getUsertype().equals("OTT"))
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_USER_TYPE.getValue(), userId, operationId);

        // SERVICE_TYPE
        if (customer.getServicetype() == null || customer.getServicetype().isEmpty() || customer.getServicetype().isBlank())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_SERVICE_TYPE.getValue(), userId, operationId);
        if (customer.getServicetype().length() > 32)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SERVICE_TYPE.getValue(), userId, operationId);

        //STB_IP
            if (customer.getListstbips().getStbip().isEmpty()) {
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_DEVICE.getValue(), userId, operationId);
        }
        for (String ip : customer.getListstbips().getStbip()) {
            if (ip.isEmpty()) throw new CustomerException().getErrorInfo(
                    ErrorCodeEnum.OBLIGATORY_FIELD_DEVICE.getValue(), userId, operationId);

            if (ip.length() > 15) throw new CustomerException().getErrorInfoListService(
                    ErrorCodeEnum.FORMAT_ERROR_DEVICE.getValue(),ip ,userId, operationId);
        }
        for (String ip : customer.getListstbips().getStbip()) {
            if (ip.isEmpty() || ip.isBlank() || ip == null)
            //if (ip == null)
                throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_DEVICE.getValue(), userId, operationId);
            if (ip.length() > 15) throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_DEVICE.getValue(), userId, operationId);
        }

        // TV_SERVICE_ID
        if (customer.getListtvservices() != null) {
            if (customer.getListtvservices().getTvservice() != null) {
                for (TvService tvservice : customer.getListtvservices().getTvservice()) {
                    if(tvservice.getTvserviceid() == null || tvservice.getTvserviceid().isBlank() || tvservice.getTvserviceid().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_ID.getValue(), userId, operationId);
                    /*if (tvservice.getTvserviceid().isBlank() || tvservice.getTvserviceid().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(), userId, operationId);*/
                    if (!tvservice.getTvserviceid().matches("^\\p{ASCII}*$") || tvservice.getTvserviceid().length() > 32)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(), userId, operationId);

                    // TV_SERVICE_OPER si TV_SERVICE_ID presente
                    if (tvservice.getTvserviceoper() == null || tvservice.getTvserviceoper().value().isEmpty() || tvservice.getTvserviceoper().value().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_PACKACGE_OPERATION.getValue(), userId, operationId);
                    if (!tvservice.getTvserviceoper().value().equals("ON") && !tvservice.getTvserviceoper().value().equals("OFF") && !tvservice.getTvserviceoper().value().equals("KEEP"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(), userId, operationId);
                }
            }
        }

        // POP
        if (customer.getPop() == null || customer.getPop().isEmpty() || customer.getPop().isBlank())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_POP.getValue(), userId, operationId);
        if (customer.getPop().length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_POP.getValue(), userId, operationId);
        boolean isNumericPop =  customer.getPop().matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNumericPop) throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_POP.getValue(), userId, operationId);

        // SUBSCRIBER_LINE_UPSTREAM
        if (customer.getSubscriberline().getUpstream() == null || customer.getSubscriberline().getUpstream().isBlank() ||
                customer.getSubscriberline().getUpstream().isEmpty())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_SUSCRIBER_LINE_UPSTREAM.getValue(), userId, operationId);
        if (customer.getSubscriberline().getUpstream().length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SUSCRIBER_LINE_UPSTREAM.getValue(), userId, operationId);
        boolean isNumericUpsstream =  customer.getSubscriberline().getUpstream().matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNumericUpsstream) throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SUSCRIBER_LINE_UPSTREAM.getValue(), userId, operationId);

        // SUBSCRIBER_LINE_DOWNSTREAM
        if (customer.getSubscriberline().getDownstream() == null || customer.getSubscriberline().getDownstream().isEmpty() ||
        customer.getSubscriberline().getDownstream().isBlank())
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_SUSCRIBER_LINE_DOWNSTREAM.getValue(), userId, operationId);
        if (customer.getSubscriberline().getDownstream().length() > 9)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SUSCRIBER_LINE_DOWNSTREAM.getValue(), userId, operationId);
        boolean isNumericDownstream =  customer.getSubscriberline().getDownstream().matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNumericDownstream) throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_SUSCRIBER_LINE_DOWNSTREAM.getValue(), userId, operationId);

        if (customer.getListvodservices() != null) {
            if (customer.getListvodservices().getVodservice() != null) {
                for (VodService vodservice : customer.getListvodservices().getVodservice()) {
                    // VOD_SERVICE_ID, si LIST_VOD_SERVICE presente
                    if (vodservice.getVodserviceid() == null || vodservice.getVodserviceid().isBlank() || vodservice.getVodserviceid().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_VOD_SERVICE_ID.getValue(), userId, operationId);
                    /*if (vodservice.getVODSERVICEID().isBlank() || vodservice.getVODSERVICEID().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_ID.getValue(), userId, operationId);*/
                    if (!vodservice.getVodserviceid().matches("^\\p{ASCII}*$") || vodservice.getVodserviceid().length() > 32)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_ID.getValue(), userId, operationId);

                    //VOD_SERVICE_OPER si VOD_SERVICE_ID presente
                    if(vodservice.getVodserviceoper() == null || vodservice.getVodserviceoper().value().isBlank() || vodservice.getVodserviceoper().value().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_OPER.getValue(), userId, operationId);
                    /*if (vodservice.getVODSERVICEOPER().value().isBlank() || vodservice.getVODSERVICEOPER().value().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), userId, operationId);*/
                    if (!vodservice.getVodserviceoper().value().equals("ON") && !vodservice.getVodserviceoper().value().equals("OFF") && !vodservice.getVodserviceoper().value().equals("KEEP"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), userId, operationId);

                }
            }
        }
        if (customer.getListoperatorbonus() != null) {
            if (customer.getListoperatorbonus().getOPERATORBONUS() != null) {
                for (OPERATORBONUS operatorbonus : customer.getListoperatorbonus().getOPERATORBONUS()) {
                    //String operation = operatorbonus.getOperation().value();

                    // OPERATOR_BONUS si LIST_OPERATOR_BONUS presente
                    if (operatorbonus.getValue().isEmpty() || operatorbonus.getValue().isBlank() || operatorbonus.getValue() == null || operatorbonus == null)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATOR_BONUS.getValue(), userId, operationId);
                    if (operatorbonus.getValue().length() > 32)
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_OPERATOR_BONUS.getValue(), userId, operationId);

                    // operation si LIST_OPERATOR_BONUS presente
                    if (operatorbonus.getOperation() == null || operatorbonus.getOperation().value().isBlank() || operatorbonus.getOperation().value().isEmpty())
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_OPERATION_OPERATOR_BONUS.getValue(), userId, operationId);
                    if (!operatorbonus.getOperation().equals("ON") && !operatorbonus.getOperation().equals("OFF") && !operatorbonus.getOperation().equals("KEEP"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_OPERATION_OPERATOR_BONUS.getValue(), userId, operationId);

                }
            }
        }

        // ADDRESSING (solo debe comprobarse el formato)
        if (customer.getAddressing() != null && !customer.getAddressing().equals("STATIC_IP") && !customer.getAddressing().equals("STATIC_IP_NAT") && !customer.getAddressing().equals("DYNAMIC_IP") && !customer.getAddressing().equals("DYNAMIC_IP_MAC"))
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_ADDRESSING.getValue(), userId, operationId);

        // MAX_NUM_STBS (solo debe comprobarse el formato)
        boolean isNumberMaxStbs =  customer.getMaxnumstbs().matches("[+-]?\\d*(\\.\\d+)?");
        if (customer.getMaxnumstbs().length() > 99 || !isNumberMaxStbs)
            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_MAX_NUM_STBS.getValue(), userId, operationId);
    }

}
