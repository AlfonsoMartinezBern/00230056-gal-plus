package com.telefonica.gal.SPAIN_TD_CDBProvision.api;

import com.telefonica.gal.SPAIN_TD_CDBProvision.service.CDBProvisionService;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cdbprovision")
public class ApiCDBProvisionServiceServiceImpl implements ApiCDBProvisionService {
    private static final Logger LOGGER = LogManager.getLogger("LOGGER_WITH_JSON_LAYOUT");

    private final CDBProvisionService cdbProvisionService;

    @Autowired
    public ApiCDBProvisionServiceServiceImpl(final CDBProvisionService customerProvisionService) {
        this.cdbProvisionService = customerProvisionService;
    }

    @Override
    @PutMapping //("/provision/OTT/{adminCode}")
    public ResponseEntity<String> provisionOTTAdminCodePut(@RequestParam String adminCode, @RequestBody CDBProvisionRequest cdbProvisionRequest) throws Exception{
        try {
            LOGGER.info("Customer request CreateUser=========== ");

            ResponseEntity<String> responseEntity = new ResponseEntity<String>(cdbProvisionService.provisionOTTAdminCodePut(adminCode, cdbProvisionRequest), HttpStatus.OK);

            return responseEntity;
        } catch (Exception e) {
            LOGGER.info("Exception:  " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

