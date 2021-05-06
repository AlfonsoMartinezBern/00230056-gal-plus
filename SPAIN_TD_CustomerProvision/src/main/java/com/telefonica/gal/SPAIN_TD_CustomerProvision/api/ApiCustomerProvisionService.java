package com.telefonica.gal.SPAIN_TD_CustomerProvision.api;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;

public interface ApiCustomerProvisionService {
    CUSTOMERPROVISIONRESPONSE customersProvision(CUSTOMERPROVISIONREQUEST customerprovisionrequest);
}
