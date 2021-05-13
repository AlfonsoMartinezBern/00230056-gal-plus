package com.telefonica.gal.SPAIN_TD_CustomerProvision.api;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import org.springframework.http.ResponseEntity;
import org.xml.sax.SAXParseException;

public interface ApiCustomerProvisionService {
    ResponseEntity<CUSTOMERPROVISIONRESPONSE> customersProvision(CUSTOMERPROVISIONREQUEST customerprovisionrequest) throws SAXParseException;
    ResponseEntity<CUSTOMERPROVISIONRESPONSE> customersProvisionMod(CUSTOMERPROVISIONREQUEST customerprovisionrequest) throws Exception;
    ResponseEntity<CUSTOMERPROVISIONRESPONSE> customersProvisionOff(CUSTOMERPROVISIONREQUEST customerprovisionrequest) throws Exception;
}
