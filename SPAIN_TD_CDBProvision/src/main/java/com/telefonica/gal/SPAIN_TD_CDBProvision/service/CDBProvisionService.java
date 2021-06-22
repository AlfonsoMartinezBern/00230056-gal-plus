package com.telefonica.gal.SPAIN_TD_CDBProvision.service;

import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;

public interface CDBProvisionService {
    String provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest cdbProvisionRequest);
}
