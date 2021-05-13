package com.telefonica.gal.SPAIN_TD_CustomerProvision.service;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMER;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import org.springframework.stereotype.Service;

@Service
public class CustomerProvisionServiceImpl implements CustomerProvisionService {

    @Override
    public CUSTOMERPROVISIONRESPONSE customersProvision(CUSTOMERPROVISIONREQUEST customerprovisionrequest) {

        CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();
        CUSTOMERS customers = new CUSTOMERS();

        response.setCUSTOMERS(customers);

        //Invocar al dinamic routing para conocer la el endPoint que vamos a invocar

        //Invocar a la factory

        return response;
    }
}
