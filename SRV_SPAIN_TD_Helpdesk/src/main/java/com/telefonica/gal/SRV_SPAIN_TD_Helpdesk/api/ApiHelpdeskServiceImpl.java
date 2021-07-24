package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.api;

import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.service.HelpdeskService;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.service.HelpdeskServiceImpl;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.utils.SpringUtil;
import com.telefonica.gal.wsdl.getProfile.*;
import com.telefonica.gal.wsdl.getProfile.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.StringReader;

public class ApiHelpdeskServiceImpl implements ApiHelpdeskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiHelpdeskServiceImpl.class.getName());

    // MUST BE INJECTED THIS WAY TO BE INTERPRETED BY WSDD
    private final HelpdeskServiceImpl helpdeskService =  SpringUtil.getBean(HelpdeskServiceImpl.class);

    @Override
    public GetProfileResponse getProfile(GetProfileRequest getProfileRequest) throws Exception {

        LOGGER.info("Helpdesk request GetProfile=========== ");

        GetProfileResponse getProfileResponse = helpdeskService.getProfile(getProfileRequest);

        return getProfileResponse;
    }
}
