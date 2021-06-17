package com.telefonica.gal.SPAIN_TD_CDBProvision.api;

import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;
import org.springframework.http.ResponseEntity;

public interface ApiCDBProvisionService {
    ResponseEntity<InlineResponse200> provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest UNKNOWN_BASE_TYPE) throws Exception;
}
