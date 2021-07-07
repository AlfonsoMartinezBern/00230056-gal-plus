package com.telefonica.gal.SPAIN_TD_CDBProvision.service;

import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.ErrorMessage;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;

public interface CDBProvisionService {
    String provisionOTTAdminCodePut(String adminCode, String cdbProvisionRequest) throws ErrorMessage;
}
