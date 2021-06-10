package com.telefonica.gal.service;

import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.exception.ErrorMessage;
import com.telefonica.gal.factory.FactoryTD;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.CUSTOMERS;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import com.telefonica.gal.validate.ValidateConsolidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;

@Service
public class ConsolidationServiceImpl implements ConsolidationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsolidationServiceImpl.class.getName());
    private static final String ServicesConsolidation = "ServicesConsolidation";

    ISpainDynamicRoutingTD dynamicRoutingTD;

    FactoryTD factoryTD;


    @Autowired
    public ConsolidationServiceImpl(final ISpainDynamicRoutingTD dynamicRoutingTD, final FactoryTD factoryTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
        this.factoryTD = factoryTD;

    }

    @Override
    public SERVICESCONSOLIDATIONRESPONSE consolidationPackageService(SERVICESCONSOLIDATIONREQUEST request) {
        SERVICESCONSOLIDATIONRESPONSE servicesconsolidationresponse = new SERVICESCONSOLIDATIONRESPONSE();
        RoutingTDKey tdKey;
        RoutingTDInfo routingTDInfo;
        Map<String, Object> haspMap = null;
        CUSTOMERS customers = new CUSTOMERS();
        com.telefonica.gal.servicesConsolidation.response.CUSTOMER customerResponseError = new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();

        try {
            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                ValidateConsolidation.validateRequest(customer);

            }
            System.out.println("SIGO CON LA PROVISION ===== >");

            routingTDInfo = new RoutingTDInfo();
            tdKey = new RoutingTDKey(ServicesConsolidation);
            routingTDInfo = dynamicRoutingTD.search(tdKey);

            //Invocar al Factory
            servicesconsolidationresponse = factoryTD.invokeWs(routingTDInfo, request, haspMap);


            return servicesconsolidationresponse;

        } catch (ErrorMessage errorMessage) {
            customerResponseError.setUSERID(errorMessage.getUserid());
            customerResponseError.setOPERATIONID(errorMessage.getOperationid());
            customerResponseError.setRESULTCODE(new BigInteger(errorMessage.getCodError()));
            customerResponseError.setDESCRIPTION(errorMessage.getMessage());

            customers.getCUSTOMER().add(customerResponseError);
            servicesconsolidationresponse.setCUSTOMERS(customers);

            return servicesconsolidationresponse;
        }

    }
}
