package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.service;

import com.telefonica.gal.wsdl.getProfile.GetProfileRequest;
import com.telefonica.gal.wsdl.getProfile.GetProfileResponse;

public interface HelpdeskService {
    GetProfileResponse getProfile(GetProfileRequest getProfileRequest);
}
