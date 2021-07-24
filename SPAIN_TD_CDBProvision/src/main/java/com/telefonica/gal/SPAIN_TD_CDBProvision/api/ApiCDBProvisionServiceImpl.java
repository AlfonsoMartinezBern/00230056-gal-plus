package com.telefonica.gal.SPAIN_TD_CDBProvision.api;

import com.telefonica.gal.SPAIN_TD_CDBProvision.dto.ServiceInfoCustomer;
import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CDBProvision.service.CDBProvisionService;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cdbprovision")
public class ApiCDBProvisionServiceImpl implements ApiCDBProvisionService {
    private static final Logger LOGGER = LogManager.getLogger(ApiCDBProvisionServiceImpl.class);
    private static Logger loggerWithCustomLayout = LogManager.getLogger("LOGS_CUSTOMER_V1");
    private ServiceInfoCustomer serviceInfoDto = new ServiceInfoCustomer("SPAIN_TD_CDBProvision");

    private final CDBProvisionService cdbProvisionService;

    @Autowired
    public ApiCDBProvisionServiceImpl(final CDBProvisionService customerProvisionService) {
        this.cdbProvisionService = customerProvisionService;
    }

    @Override
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/rest/provision/OTT/{adminCode}")
    public ResponseEntity<String> provisionOTTAdminCodePut(@PathVariable String adminCode, @RequestBody CDBProvisionRequest cdbProvisionRequest) throws ErrorMessage{
            LOGGER.info("Customer request CreateUser=========== ");

            ResponseEntity<String> responseEntity = new ResponseEntity<String>(cdbProvisionService.provisionOTTAdminCodePut(adminCode, cdbProvisionRequest), HttpStatus.OK);

            return responseEntity;
    }

}

