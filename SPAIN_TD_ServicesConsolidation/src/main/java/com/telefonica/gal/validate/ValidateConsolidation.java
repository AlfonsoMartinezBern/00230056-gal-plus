package com.telefonica.gal.validate;

import com.telefonica.gal.exception.ConsolidationException;
import com.telefonica.gal.exception.CustomerException;
import com.telefonica.gal.exception.ErrorMessage;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.request.TVSERVICE;
import com.telefonica.gal.servicesConsolidation.request.VODSERVICE;
import com.telefonica.gal.utils.ErrorCodeEnum;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class ValidateConsolidation {

    public void isValid(SERVICESCONSOLIDATIONREQUEST servicesconsolidationrequest, String request) throws ErrorMessage {
        isValid(request);
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

                    throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(), tvservice.getTVSERVICEID(), userId, operationId);

                    /*throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_ID.getValue(),
                                                                    tvservice.getTVSERVICEID());*/

                } else {
                    if (tvservice.getTVSERVICEOPER() == null)
                        throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_TV_SERVICE_OPER.getValue(), userId, operationId);
                    if (!tvservice.getTVSERVICEOPER().value().equals("ON") && !tvservice.getTVSERVICEOPER().value().equals("OFF") && !tvservice.getTVSERVICEOPER().value().equals("KEEP"))
                        throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(), tvservice.getTVSERVICEOPER().value(), userId, operationId);
                }
            }
        }


        if (request.getLISTVODSERVICES() != null) {
            for (VODSERVICE vodservice : request.getLISTVODSERVICES().getVODSERVICE()) {
                if (vodservice.getVODSERVICEID() == null || vodservice.getVODSERVICEID().isEmpty()) {
                    throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_VOD_SERVICE_ID.getValue(), userId, operationId);

                }
                if (!vodservice.getVODSERVICEID().matches("[\\p{ASCII}&&[^\\x5F]]{1,32}")) {
                    throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_ID.getValue(), vodservice.getVODSERVICEID(), userId, operationId);
                } else {
                    if (vodservice.getVODSERVICEOPER() == null)
                        throw new ConsolidationException().getErrorInfo(ErrorCodeEnum.OBLIGATORY_FIELD_VOD_SERVICE_ID.getValue(), userId, operationId);
                    if (!vodservice.getVODSERVICEOPER().value().equals("ON") && !vodservice.getVODSERVICEOPER().value().equals("OFF") && !vodservice.getVODSERVICEOPER().value().equals("KEEP"))
                        throw new ConsolidationException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), vodservice.getVODSERVICEOPER().toString(), userId, operationId);
                }

            }

        }

    }

    public void isValid(String request) throws ErrorMessage {
        String tvServiceOper, userId, operationId, maxnumstbs;
        String customerProvisionRequest = XML.toJSONObject(request).get("SERVICES_CONSOLIDATION_REQUEST").toString();
        String customers;
        try {
            customers = new JSONObject(customerProvisionRequest).get("CUSTOMERS").toString();
            if (customers.contains("{\"CUSTOMER\":[")) {
                for (Object customer : new JSONArray(new JSONObject(customers).get("CUSTOMER").toString())) {

                    userId = new JSONObject(customer).get("USER_ID").toString();
                    operationId = new JSONObject(customer).get("OPERATION_ID").toString();;
                    maxnumstbs = new JSONObject(customer).get("MAX_NUM_STBS").toString();

                    // if (!maxnumstbs.matches("[+-]?\\d*(\\.\\d+)?"))
                    //    throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_MAX_NUM_STBS.getValue(), userId, operationId);

                    for (Object tvService : new JSONArray(new JSONObject(new JSONObject(new JSONObject(customer.toString()).toString()).get("LIST_TV_SERVICES").toString()).get("TV_SERVICE").toString())) {
                        tvServiceOper = new JSONObject(new JSONObject(tvService.toString()).toString()).get("TV_SERVICE_OPER").toString();
                        if (tvServiceOper == null || tvServiceOper == "" || tvServiceOper.isEmpty() || tvServiceOper.isBlank()) return;
                        if (!tvServiceOper.equals("ON") && !tvServiceOper.equals("OFF") && !tvServiceOper.equals("MOD"))
                            throw new CustomerException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(), tvServiceOper, userId, operationId);
                    }
                    for (Object tvService : new JSONArray(new JSONObject(new JSONObject(new JSONObject(customer.toString()).toString()).get("LIST_VOD_SERVICES").toString()).get("VOD_SERVICE").toString())) {
                        tvServiceOper = new JSONObject(new JSONObject(tvService.toString()).toString()).get("VOD_SERVICE_OPER").toString();
                        if (tvServiceOper == null || tvServiceOper == "" || tvServiceOper.isEmpty() || tvServiceOper.isBlank()) return;
                        if (!tvServiceOper.equals("ON") && !tvServiceOper.equals("OFF") && !tvServiceOper.equals("MOD"))
                            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), userId, operationId);
                    }
                }
            } else {
                String customerString = new JSONObject(new JSONObject(customers).get("CUSTOMER").toString()).toString();
                userId = new JSONObject(customerString).get("USER_ID").toString();
                operationId = new JSONObject(customerString).get("OPERATION_ID").toString();

                if (customerString.contains("\"TV_SERVICE\":[")) {
                    for (Object tvService : new JSONArray(new JSONObject(new JSONObject(customerString).get("LIST_TV_SERVICES").toString()).get("TV_SERVICE").toString())) {
                        tvServiceOper = new JSONObject(new JSONObject(tvService.toString()).toString()).get("TV_SERVICE_OPER").toString();
                        if (tvServiceOper == null || tvServiceOper == "" || tvServiceOper.isEmpty() || tvServiceOper.isBlank()) return;
                        if (!tvServiceOper.equals("ON") && !tvServiceOper.equals("OFF") && !tvServiceOper.equals("MOD"))
                            throw new CustomerException().getErrorInfoListService(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(), tvServiceOper, userId, operationId);
                    }
                } else {
                    tvServiceOper = new JSONObject(new JSONObject(new JSONObject(new JSONObject(customerString).get("LIST_TV_SERVICES").toString()).get("TV_SERVICE").toString()).toString()).get("TV_SERVICE_OPER").toString();
                    if (tvServiceOper == null || tvServiceOper == "" || tvServiceOper.isEmpty() || tvServiceOper.isBlank()) return;
                    if (!tvServiceOper.equals("ON") && !tvServiceOper.equals("OFF") && !tvServiceOper.equals("MOD"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_TV_SERVICE_OPER.getValue(), userId, operationId);
                }

                if (customerString.contains("\"VOD_SERVICE\":[")) {
                    for (Object tvService : new JSONArray(new JSONObject(new JSONObject().get("LIST_VOD_SERVICES").toString()).get("VOD_SERVICE").toString())) {
                        tvServiceOper = new JSONObject(new JSONObject(tvService.toString()).toString()).get("VOD_SERVICE_OPER").toString();
                        if (tvServiceOper == null || tvServiceOper == "" || tvServiceOper.isEmpty() || tvServiceOper.isBlank()) return;
                        if (!tvServiceOper.equals("ON") && !tvServiceOper.equals("OFF") && !tvServiceOper.equals("MOD"))
                            throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), userId, operationId);
                    }
                } else {
                    tvServiceOper = new JSONObject(new JSONObject(new JSONObject(new JSONObject(customerString).get("LIST_VOD_SERVICES").toString()).get("VOD_SERVICE").toString()).toString()).get("VOD_SERVICE_OPER").toString();
                    if (tvServiceOper == null || tvServiceOper == "" || tvServiceOper.isEmpty() || tvServiceOper.isBlank()) return;
                    if (!tvServiceOper.equals("ON") && !tvServiceOper.equals("OFF") && !tvServiceOper.equals("MOD"))
                        throw new CustomerException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_VOD_SERVICE_OPER.getValue(), userId, operationId);
                }
            }
        } catch (Exception e) {
            return;
        }

    }
}
