package com.telefonica.gal.SPAIN_TD_CDBProvision.service;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;

import java.math.BigInteger;

public class CDBProvisionServiceImpl implements CDBProvisionService {

    private FactoryTD factoryTD;

    private CustomerProvisionValidator customerProvisionValidator = new CustomerProvisionValidator();


    @Override
    public InlineResponse200 provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest cdbProvisionRequest){
        try {
            CDBProvisionServiceValidator.isValid(cdbProvisionRequest);
            return factoryTD.invokeWs(dynamicRoutingTD.search(new RoutingTDKey(/* TODO */ "CDBProvision")), cdbProvisionRequest, null);

        } catch (ErrorMessage errorMessage) {
            CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();
            CUSTOMERS customers = new CUSTOMERS();
            CUSTOMER customerResponseError = new CUSTOMER();

            customerResponseError.setUSERID(errorMessage.getUserid());
            customerResponseError.setOPERATIONID(errorMessage.getOperationid());
            customerResponseError.setRESULTCODE(new BigInteger(errorMessage.getCodError()));
            customerResponseError.setDESCRIPTION(errorMessage.getMessage());

            customers.getCUSTOMER().add(customerResponseError);
            response.setCUSTOMERS(customers);

            return response;
        }
    }

}
