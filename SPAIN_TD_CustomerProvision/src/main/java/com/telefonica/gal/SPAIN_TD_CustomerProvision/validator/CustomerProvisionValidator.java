package com.telefonica.gal.SPAIN_TD_CustomerProvision.validator;


import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.CustomerException;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.ErrorMessage;
import com.telefonica.gal.customerProvision.request.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

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
            throw new CustomerException().getErrorInfo("GAL-03", userId, operationId);
        if (!customer.getUSERID().matches("^\\p{ASCII}*$") || customer.getUSERID().length() > 32)
            throw new CustomerException().getErrorInfo("GAL-02", userId, operationId);

        // OPERATION_TYPE
        if (customer.getOPERATIONTYPE().isEmpty() || customer.getOPERATIONTYPE().isBlank() || customer.getOPERATIONTYPE() == null)
            throw new CustomerException().getErrorInfo("GAL-05", userId, operationId);
        if (!customer.getOPERATIONTYPE().equals("ON") && !customer.getOPERATIONTYPE().equals("MOD") && !customer.getOPERATIONTYPE().equals("OFF"))
            throw new CustomerException().getErrorInfo("GAL-04", userId, operationId);

        // GEOGRAFIC_AREA
        if (customer.getGEOGRAFICAREA() == 0) throw new CustomerException().getErrorInfo("11", userId, operationId);
        if (String.valueOf(customer.getGEOGRAFICAREA()).length() > 9)
            throw new CustomerException().getErrorInfo("GAL-10", userId, operationId);

        // USER_TYPE
        if (customer.getUSERTYPE().isEmpty() || customer.getUSERTYPE().isBlank() || customer.getUSERTYPE() == null)
            throw new CustomerException().getErrorInfo("GAL-14", userId, operationId);
        if (!customer.getUSERTYPE().equals("RESIDENTIAL") && !customer.getUSERTYPE().equals("BUSINESS") && !customer.getUSERTYPE().equals("OTT"))
            throw new CustomerException().getErrorInfo("GAL-13", userId, operationId);

        // SERVICE_TYPE
        if (customer.getSERVICETYPE().isEmpty() || customer.getSERVICETYPE().isBlank() || customer.getSERVICETYPE() == null)
            throw new CustomerException().getErrorInfo("GAL-17", userId, operationId);
        if (!customer.getSERVICETYPE().equals("DFLT1") && !customer.getSERVICETYPE().equals("DFLT2") && !customer.getSERVICETYPE().equals("OTT"))
            throw new CustomerException().getErrorInfo("GAL-16", userId, operationId);

        //STB_IP
        for (String ip : customer.getLISTSTBIPS().getSTBIP()) {
            if (ip.isEmpty() || ip.isBlank() || ip == null)
                throw new CustomerException().getErrorInfo("GAL-25", userId, operationId);
            if (ip.length() > 15) throw new CustomerException().getErrorInfo("GAL-24", userId, operationId);
        }

        // TV_SERVICE_ID
        if (customer.getLISTTVSERVICES() != null) {
            if (customer.getLISTTVSERVICES().getTVSERVICE() != null) {
                for (TVSERVICE tvservice : customer.getLISTTVSERVICES().getTVSERVICE()) {
                    String serviceID = tvservice.getTVSERVICEID();
                    String serviceOP = tvservice.getTVSERVICEOPER().value();
                    if (serviceID.isBlank() || serviceID.isEmpty() || serviceID == null)
                        throw new CustomerException().getErrorInfo("GAL-28", userId, operationId);
                    if (!serviceID.matches("^\\p{ASCII}*$") || serviceID.length() > 32)
                        throw new CustomerException().getErrorInfo("GAL-27", userId, operationId);

                    // TV_SERVICE_OPER si TV_SERVICE_ID presente
                    if (tvservice.getTVSERVICEOPER() == null)
                        throw new CustomerException().getErrorInfo("GAL-48", userId, operationId);
                    if (!serviceOP.equals("ON") && !serviceOP.equals("OFF") && !serviceOP.equals("KEEP"))
                        throw new CustomerException().getErrorInfo("GAL-49", userId, operationId);
                }
            }
        }

        // POP
        if (customer.getPOP() == 0)
            throw new CustomerException().getErrorInfo("GAL-34", userId, operationId);
        if (String.valueOf(customer.getPOP()).length() > 9)
            throw new CustomerException().getErrorInfo("GAL-33", userId, operationId);

        // SUBSCRIBER_LINE_UPSTREAM
        if (customer.getSUBSCRIBERLINE().getUPSTREAM() == 0)
            throw new CustomerException().getErrorInfo("GAL-75", userId, operationId);
        if (String.valueOf(customer.getSUBSCRIBERLINE().getUPSTREAM()).length() > 9)
            throw new CustomerException().getErrorInfo("GAL-76", userId, operationId);

        // SUBSCRIBER_LINE_DOWNSTREAM
        if (customer.getSUBSCRIBERLINE().getDOWNSTREAM() == 0)
            throw new CustomerException().getErrorInfo("GAL-77", userId, operationId);
        if (String.valueOf(customer.getSUBSCRIBERLINE().getDOWNSTREAM()).length() > 9)
            throw new CustomerException().getErrorInfo("GAL-78", userId, operationId);

        if (customer.getLISTVODSERVICES() != null) {
            if (customer.getLISTVODSERVICES().getVODSERVICE() != null) {
                for (VODSERVICE vodservice : customer.getLISTVODSERVICES().getVODSERVICE()) {
                    String vodServiceID = vodservice.getVODSERVICEID();
                    String vodServiceOp = vodservice.getVODSERVICEOPER().value();

                    // VOD_SERVICE_ID, si LIST_VOD_SERVICE presente
                    if (vodServiceID.isBlank() || vodServiceID.isEmpty() || vodServiceID == null)
                        throw new CustomerException().getErrorInfo("GAL-31", userId, operationId);
                    if (!vodServiceID.matches("^\\p{ASCII}*$") || vodServiceID.length() > 32)
                        throw new CustomerException().getErrorInfo("GAL-30", userId, operationId);

                    //VOD_SERVICE_OPER si VOD_SERVICE_ID presente
                    if (vodServiceOp.isBlank() || vodServiceOp.isEmpty() || vodServiceOp == null)
                        throw new CustomerException().getErrorInfo("GAL-50", userId, operationId);
                    if (!vodServiceOp.equals("ON") && !vodServiceOp.equals("OFF") && !vodServiceOp.equals("KEEP"))
                        throw new CustomerException().getErrorInfo("GAL-51", userId, operationId);

                }
            }
        }
        if (customer.getLISTOPERATORBONUS() != null) {
            if (customer.getLISTOPERATORBONUS().getOPERATORBONUS() != null) {
                for (OPERATORBONUS operatorbonus : customer.getLISTOPERATORBONUS().getOPERATORBONUS()) {
                    String operation = operatorbonus.getOperation().value();

                    // OPERATOR_BONUS si LIST_OPERATOR_BONUS presente
                    if (operatorbonus.getValue().isEmpty() || operatorbonus.getValue().isBlank() || operatorbonus.getValue() == null || operatorbonus == null)
                        throw new CustomerException().getErrorInfo("GAL-43", userId, operationId);
                    // Formato erróneo throw new CustomerException().getErrorInfo("47", userId, operationId); // TODO

                    // operation si LIST_OPERATOR_BONUS presente
                    if (operatorbonus.getOperation() == null)
                        throw new CustomerException().getErrorInfo("GAL-46", userId, operationId);
                    if (!operation.equals("ON") && !operation.equals("OFF") && !operation.equals("KEEP"))
                        throw new CustomerException().getErrorInfo("GAL-47", userId, operationId);

                }
            }
        }

        // ADDRESSING (solo debe comprobarse el formato)
        if (customer.getADDRESSING() != null && !customer.getADDRESSING().equals("STATIC_IP") && !customer.getADDRESSING().equals("STATIC_IP_NAT") && !customer.getADDRESSING().equals("DYNAMIC_IP") && !customer.getADDRESSING().equals("DYNAMIC_IP_MAC"))
            throw new CustomerException().getErrorInfo("GAL-83", userId, operationId);

        // MAX_NUM_STBS (solo debe comprobarse el formato)
        if (customer.getMAXNUMSTBS() > 99)
            throw new CustomerException().getErrorInfo("GAL-86", userId, operationId);

        throw new CustomerException().getErrorInfo("0", userId, operationId);
    }

}
