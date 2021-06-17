package com.telefonica.gal.SPAIN_TD_CDBProvision.service;

import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CDBProvision.validator.CDBProvisionValidator;
import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.factory.FactoryTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDBProvisionServiceImpl implements CDBProvisionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CDBProvisionServiceImpl.class.getName());
    private static final String CDBProvision = "CDBProvision";

    private ISpainDynamicRoutingTD dynamicRoutingTD;

    private FactoryTD factoryTD;

    private CDBProvisionValidator cdbProvisionValidator = new CDBProvisionValidator();

    @Autowired
    public CDBProvisionServiceImpl(ISpainDynamicRoutingTD dynamicRoutingTD, FactoryTD factoryTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
        this.factoryTD = factoryTD;
    }

    @Override
    public InlineResponse200 provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest cdbProvisionRequest) {

        try {
            cdbProvisionValidator.isValid(adminCode, cdbProvisionRequest);
            return factoryTD.invokeWs(dynamicRoutingTD.search(new RoutingTDKey(CDBProvision)), cdbProvisionRequest, adminCode);

        } catch (ErrorMessage errorMessage) {
            /*CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();
            CUSTOMERS customers = new CUSTOMERS();
            CUSTOMER customerResponseError = new CUSTOMER();

            customerResponseError.setUSERID(errorMessage.getUserid());
            customerResponseError.setOPERATIONID(errorMessage.getOperationid());
            customerResponseError.setRESULTCODE(new BigInteger(errorMessage.getCodError()));
            customerResponseError.setDESCRIPTION(errorMessage.getMessage());

            customers.getCUSTOMER().add(customerResponseError);
            response.setCUSTOMERS(customers);*/ // TODO

            return null; //response
        }
    }
}
