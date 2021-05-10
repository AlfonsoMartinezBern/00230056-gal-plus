package com.telefonica.gal.SPAIN_TD_CustomerProvision.service;

import com.telefonica.gal.client.dynamicrouting.td.facade.SpainDynamicRoutingTD;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerProvisionServiceImpl implements CustomerProvisionService {

    private final SpainDynamicRoutingTD dynamicRoutingTD;

    @Autowired
    public CustomerProvisionServiceImpl(final SpainDynamicRoutingTD dynamicRoutingTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
    }

   /* @Autowired
    FactoryTD factoryTD;*/

    @Override
    public CUSTOMERPROVISIONRESPONSE customersProvision(CUSTOMERPROVISIONREQUEST customerprovisionrequest) {

        CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();
        CUSTOMERS customers = new CUSTOMERS();

        response.setCUSTOMERS(customers);

        String operationTD = customerprovisionrequest.getCUSTOMERS().getCUSTOMER().get(0).getOPERATIONID();

        //Invocar al dynamicRoutingTD para conocer la el endPoint que vamos a invocar
        RoutingTDKey tdKey = new RoutingTDKey("OTT", "CreateUser", "http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management");
        //RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(tdKey);

        //Invocar a la factory
        //response = factoryTD.invokeMiViewService(customerprovisionrequest);

        return response;
    }
}
