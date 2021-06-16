package com.telefonica.gal.service;

import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.dto.LogDto;
import com.telefonica.gal.dto.ServiceInfoDto;
import com.telefonica.gal.exception.ErrorMessage;
import com.telefonica.gal.factory.FactoryTD;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.CUSTOMERS;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import com.telefonica.gal.validate.ValidateConsolidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.UUID;

@Service
public class ConsolidationServiceImpl implements ConsolidationService {
    private static Logger loggerWithCustomLayout = LogManager.getLogger("LOGS_V1");
    private static final String ServicesConsolidation = "ServicesConsolidation";
    private ServiceInfoDto serviceInfoDto = new ServiceInfoDto ("SPAIN_TD_ServicesConsolidation");

    private ValidateConsolidation validateConsolidation = new ValidateConsolidation();

    ISpainDynamicRoutingTD dynamicRoutingTD;

    FactoryTD factoryTD;


    @Autowired
    public ConsolidationServiceImpl(final ISpainDynamicRoutingTD dynamicRoutingTD, final FactoryTD factoryTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
        this.factoryTD = factoryTD;

    }

    @Override
    public SERVICESCONSOLIDATIONRESPONSE consolidationPackageService(SERVICESCONSOLIDATIONREQUEST request) {
        RoutingTDKey tdKey;
        RoutingTDInfo routingTDInfo;
        Map<String, Object> haspMap = null;

        //loggerWithCustomLayout.info(new ConsolidationServiceMessage(request));

        try {
            validateConsolidation.isValid(request);

            routingTDInfo = new RoutingTDInfo();
            tdKey = new RoutingTDKey(ServicesConsolidation);
            routingTDInfo = dynamicRoutingTD.search(tdKey);

            return factoryTD.invokeWs(routingTDInfo, request, haspMap);

        } catch (ErrorMessage errorMessage) {
            com.telefonica.gal.servicesConsolidation.response.CUSTOMER customerResponseError = new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();
            CUSTOMERS customers = new CUSTOMERS();
            SERVICESCONSOLIDATIONRESPONSE servicesconsolidationresponse = new SERVICESCONSOLIDATIONRESPONSE();
            LogDto logDto = new LogDto();

            customerResponseError.setUSERID(errorMessage.getUserid());
            customerResponseError.setOPERATIONID(errorMessage.getOperationid());
            customerResponseError.setRESULTCODE(new BigInteger(errorMessage.getCodError()));
            customerResponseError.setDESCRIPTION(errorMessage.getMessage());

            customers.getCUSTOMER().add(customerResponseError);
            servicesconsolidationresponse.setCUSTOMERS(customers);

            logDto.setIdLog(UUID.randomUUID().toString());
            logDto.setServiceInfo(serviceInfoDto);
            logDto.setMessage(errorMessage.getMessage());
            loggerWithCustomLayout.error(logDto);

            return servicesconsolidationresponse;
        }

    }

}
