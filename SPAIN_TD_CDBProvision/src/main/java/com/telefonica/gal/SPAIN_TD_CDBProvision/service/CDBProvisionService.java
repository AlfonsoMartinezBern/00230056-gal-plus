package com.telefonica.gal.SPAIN_TD_CDBProvision.service;

import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;

public interface CDBProvisionService {
    String provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest cdbProvisionRequest);
}
