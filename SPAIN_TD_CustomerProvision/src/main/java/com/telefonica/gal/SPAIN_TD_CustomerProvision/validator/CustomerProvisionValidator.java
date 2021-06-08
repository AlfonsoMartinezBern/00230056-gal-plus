package com.telefonica.gal.SPAIN_TD_CustomerProvision.validator;


import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.request.TVSERVICE;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class CustomerProvisionValidator {
    public int isValid(CUSTOMERPROVISIONREQUEST servicesconsolidationresponse) {
        int result;
        for (CUSTOMER customer : servicesconsolidationresponse.getCUSTOMERS().getCUSTOMER()) {
            result = isValid(customer);
            if (result != 0) return result;
        }
        return 0;
    }

    public int isValid(CUSTOMER customer) {
        // USER_ID
        if (customer.getUSERID().isEmpty() || customer.getUSERID().isBlank() || customer.getUSERID() == null)
            return 3;
        if (!customer.getUSERID().matches("^\\p{ASCII}*$") || customer.getUSERID().length() > 32) return 2;

        // OPERATION_TYPE
        if (customer.getOPERATIONTYPE().isEmpty() || customer.getOPERATIONTYPE().isBlank() || customer.getOPERATIONTYPE() == null)
            return 5;
        // Formato erróneo return 4

        // GEOGRAFIC_AREA
        if (customer.getGEOGRAFICAREA() == 0) return 11;
        // Formato erróneo return 10

        // USER_TYPE
        if (customer.getUSERTYPE().isEmpty() || customer.getUSERTYPE().isBlank() || customer.getUSERTYPE() == null)
            return 14;
        // Formato erróneo return 13

        //SERVICE_TYPE
        if (customer.getSERVICETYPE().isEmpty() || customer.getSERVICETYPE().isBlank() || customer.getSERVICETYPE() == null)
            return 17;
        // Formato erróneo return 16

        //STB_IP
        if (customer.getLISTSTBIPS().getSTBIP().isEmpty() || customer.getLISTSTBIPS().getSTBIP() == null || customer.getLISTSTBIPS() == null)
            return 25;
        // Formato erróneo return 24

        //TV_SERVICE_ID
        for (TVSERVICE tvservice : customer.getLISTTVSERVICES().getTVSERVICE()){
            String serviceID = tvservice.getTVSERVICEID();
            if (serviceID.isBlank() || serviceID.isEmpty() || serviceID == null)
                return 28;
            // Formato erróneo return 27
        }

        //POP
        if (customer.getPOP() == 0)
            return 34;
        // Formato erróneo return 33

        //SUBSCRIBER_LINE_UPSTREAM
        if (customer.getSUBSCRIBERLINE().getUPSTREAM() == 0) return 75;
        // Formato erróneo return 76

        //SUBSCRIBER_LINE_DOWNSTREAM
        if (customer.getSUBSCRIBERLINE().getDOWNSTREAM() == 0) return 77;
        // Formato erróneo return 78


        /*
            VOD_SERVICE_ID, si LIST_VOD_SERVICE presente
            OPERATOR_BONUS si LIST_OPERATOR_BONUS presente
            operation si LIST_OPERATOR_BONUS presente
            TV_SERVICE_OPER si TV_SERVICE_ID presente
            VOD_SERVICE_OPER si VOD_SERVICE_ID presente
            ADDRESSING (solo debe comprobarse el formato)
            MAX_NUM_STBS (solo debe comprobarse el formato)
        */

        return 0;
    }

    public int isDefined(String request) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CUSTOMERPROVISIONREQUEST.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CUSTOMERPROVISIONREQUEST customerprovisionrequest = (CUSTOMERPROVISIONREQUEST) jaxbUnmarshaller.unmarshal(new StringReader(request));

            for(CUSTOMER customer : customerprovisionrequest.getCUSTOMERS().getCUSTOMER()){
                if (!request.contains("<USER_ID>")) return 36;
                if (!request.contains("<GEOGRAFIC_AREA>")) return 12;
                if (!request.contains("<USER_TYPE>")) return 15;
                if (!request.contains("<SERVICE_TYPE>")) return 18;
                if (!request.contains("<TV_SERVICE_ID>")) return 29;

                if (request.contains("<TV_SERVICE_ID>") && !request.contains("<VOD_SERVICE_ID>")) return 32;
                if (request.contains("<TV_SERVICE_ID>") && countContainedString(request, "<VOD_SERVICE_ID>") != customer.getLISTTVSERVICES().getTVSERVICE().size()) return 32;

                if (request.contains("<OPERATOR_BONUS>") && !request.contains("<LIST_OPERATOR_BONUS>")) return 45;

                if (request.contains("<ADDRESSING>")) return 84;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    private int countContainedString(String request, String campo) {
        int count = 0;
        try {
            while (request.indexOf(campo) > -1) {
                request = request.substring(request.indexOf(campo) + campo.length());
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
