package com.telefonica.gal.api;

import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;

public interface ApiConsolidationService {

    SERVICESCONSOLIDATIONRESPONSE consolidationPackage(SERVICESCONSOLIDATIONREQUEST request);

}
