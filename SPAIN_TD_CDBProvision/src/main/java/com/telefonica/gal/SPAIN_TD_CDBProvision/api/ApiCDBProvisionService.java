package com.telefonica.gal.SPAIN_TD_CDBProvision.api;

import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;
import org.springframework.http.ResponseEntity;

public interface ApiCDBProvisionService {
    ResponseEntity<String> provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest cdbProvisionRequest) throws Exception;
}
