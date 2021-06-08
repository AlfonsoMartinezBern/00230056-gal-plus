package com.telefonica.gal.service;

import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.exception.ConsolidationException;
import com.telefonica.gal.exception.ErrorMessage;
import com.telefonica.gal.factory.FactoryTD;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import com.telefonica.gal.validate.ValidateConsolidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        try {
            ValidateConsolidation.validateRequest(request.getCUSTOMERS().getCUSTOMER().get(0));

            System.out.println("SIGO CON LA PROVISION ===== >");
            return null;

        } catch (ErrorMessage errorMessage) {
            errorMessage.getMessage();
            errorMessage.getCodError();

            System.out.println("MENSAJE ===== >" + errorMessage.getMessage());
            System.out.println("ERROR ===== >" + errorMessage.getCodError());

            return servicesconsolidationresponse;
        }


        /*routingTDInfo = new RoutingTDInfo();
        tdKey = new RoutingTDKey(ServicesConsolidation);
        routingTDInfo = dynamicRoutingTD.search(tdKey);

        //Invocar al Factory
        servicesconsolidationresponse = factoryTD.invokeWs(routingTDInfo, request, haspMap);

        return servicesconsolidationresponse;*/
    }
}
