package com.telefonica.gal.SPAIN_TD_CustomerProvision.service;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;

public interface CustomerProvisionService {
    CUSTOMERPROVISIONRESPONSE customersProvision(CUSTOMERPROVISIONREQUEST customerprovisionrequest);
}
