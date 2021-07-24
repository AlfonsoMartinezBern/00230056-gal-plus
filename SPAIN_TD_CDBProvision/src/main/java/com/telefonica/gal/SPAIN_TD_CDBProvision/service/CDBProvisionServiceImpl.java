package com.telefonica.gal.SPAIN_TD_CDBProvision.service;

import com.telefonica.gal.SPAIN_TD_CDBProvision.dto.LogCustomer;
import com.telefonica.gal.SPAIN_TD_CDBProvision.dto.ServiceInfoCustomer;
import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CDBProvision.validator.CDBProvisionValidator;
import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.factory.FactoryTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CDBProvisionServiceImpl implements CDBProvisionService {
    private static Logger loggerWithCustomLayout = LogManager.getLogger("LOGS_CUSTOMER_V1");
    private ServiceInfoCustomer serviceInfoDto = new ServiceInfoCustomer("SPAIN_TD_CDBProvision");
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
    public String provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest request) {

        try {
            cdbProvisionValidator.isValid(request);

            System.out.println("System request is Valid");

            RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(new RoutingTDKey(CDBProvision));
            String result = factoryTD.invokeWs(routingTDInfo, request, adminCode);

            return result.contains("InlineResponse200") ? "" : result;

        } catch (ErrorMessage errorMessage) {
            LogCustomer logCustomer = new LogCustomer();
            logCustomer.setIdLog(UUID.randomUUID().toString());
            logCustomer.setServiceInfo(serviceInfoDto);
            logCustomer.setMessage(errorMessage.getMessage());
            loggerWithCustomLayout.error(logCustomer);
            return errorMessage.toString();
        }


        /*try {
            CDBProvisionRequest cdbProvisionRequest = new CDBProvisionRequest(request);

            cdbProvisionValidator.isValid(cdbProvisionRequest);
            RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(new RoutingTDKey(CDBProvision));
            String result = factoryTD.invokeWs(routingTDInfo, cdbProvisionRequest, adminCode);

            return result.contains("InlineResponse200") ? "" : result;

        } catch (ErrorMessage errorMessage) {
            LogCustomer logCustomer = new LogCustomer();
            logCustomer.setIdLog(UUID.randomUUID().toString());
            logCustomer.setServiceInfo(serviceInfoDto);
            logCustomer.setMessage(errorMessage.getMessage());
            loggerWithCustomLayout.error(logCustomer);
            return errorMessage.toString();
        } catch (Exception e) {
            loggerWithCustomLayout.error(e.getMessage());
            return null;
        }*/
    }
}
