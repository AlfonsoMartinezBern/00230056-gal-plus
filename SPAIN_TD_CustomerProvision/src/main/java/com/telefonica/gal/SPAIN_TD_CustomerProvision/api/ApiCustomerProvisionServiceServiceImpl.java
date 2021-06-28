package com.telefonica.gal.SPAIN_TD_CustomerProvision.api;

import com.telefonica.gal.SPAIN_TD_CustomerProvision.service.CustomerProvisionService;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customerProvision")
public class ApiCustomerProvisionServiceServiceImpl implements ApiCustomerProvisionService {
    private static final Logger LOGGER = LogManager.getLogger("LOGGER_WITH_JSON_LAYOUT");

    private final CustomerProvisionService customerProvisionService;

    @Autowired
    public ApiCustomerProvisionServiceServiceImpl(final CustomerProvisionService customerProvisionService) {
        this.customerProvisionService = customerProvisionService;
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<CUSTOMERPROVISIONRESPONSE> apiCustomersProvision(@RequestParam String xml_request) throws Exception{
            LOGGER.info("Customer request CreateUser=========== ");

            return new ResponseEntity<CUSTOMERPROVISIONRESPONSE>(customerProvisionService.customersProvision(xml_request),
                    HttpStatus.OK);
    }

}

