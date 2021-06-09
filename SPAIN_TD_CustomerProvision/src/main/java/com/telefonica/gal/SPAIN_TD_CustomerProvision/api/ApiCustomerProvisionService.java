package com.telefonica.gal.SPAIN_TD_CustomerProvision.api;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import org.springframework.http.ResponseEntity;

public interface ApiCustomerProvisionService {
    ResponseEntity<CUSTOMERPROVISIONRESPONSE> apiCustomersProvision(String xml_request) throws Exception;
}
