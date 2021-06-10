package com.telefonica.gal.SPAIN_TD_CustomerProvision.service;

import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.validator.CustomerProvisionValidator;
import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMER;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import com.telefonica.gal.factory.FactoryTD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;

@Service
public class CustomerProvisionServiceImpl implements CustomerProvisionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProvisionServiceImpl.class.getName());
    private static final String CustomerProvision = "CustomerProvision";

    private ISpainDynamicRoutingTD dynamicRoutingTD;

    private FactoryTD factoryTD;

    private CustomerProvisionValidator customerProvisionValidator = new CustomerProvisionValidator();

    @Autowired
    public CustomerProvisionServiceImpl(ISpainDynamicRoutingTD dynamicRoutingTD, FactoryTD factoryTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
        this.factoryTD = factoryTD;
    }

    @Override
    public CUSTOMERPROVISIONRESPONSE customersProvision(CUSTOMERPROVISIONREQUEST request) {

        CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();
        try {
            customerProvisionValidator.isValid(request);

            RoutingTDKey tdKey;
            RoutingTDInfo routingTDInfo;
            Map<String, Object> haspMap = null;

            routingTDInfo = new RoutingTDInfo();
            tdKey = new RoutingTDKey(CustomerProvision);
            routingTDInfo = dynamicRoutingTD.search(tdKey);

            response = factoryTD.invokeWs(routingTDInfo, request, haspMap);


            return response;

        } catch (ErrorMessage errorMessage) {
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
