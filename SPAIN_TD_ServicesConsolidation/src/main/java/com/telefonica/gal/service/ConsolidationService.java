package com.telefonica.gal.service;

import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;

public interface ConsolidationService {
    SERVICESCONSOLIDATIONRESPONSE consolidationPackageService(SERVICESCONSOLIDATIONREQUEST request);
}
