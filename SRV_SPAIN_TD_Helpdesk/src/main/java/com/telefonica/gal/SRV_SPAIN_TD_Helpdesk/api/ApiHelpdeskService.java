package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.api;

import com.telefonica.gal.wsdl.getProfile.GetProfileRequest;
import com.telefonica.gal.wsdl.getProfile.GetProfileResponse;

public interface ApiHelpdeskService {
    GetProfileResponse getProfile(GetProfileRequest request) throws Exception;
}
