package com.telefonica.gal.SPAIN_TD_CustomerProvision.api;

import com.telefonica.gal.SPAIN_TD_CustomerProvision.service.CustomerProvisionService;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXParseException;

@RestController
@RequestMapping(path = "/customerProvision")
public class ApiCustomerProvisionServiceServiceImpl implements ApiCustomerProvisionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCustomerProvisionServiceServiceImpl.class.getName());

    private final CustomerProvisionService customerProvisionService;

    @Autowired
    public ApiCustomerProvisionServiceServiceImpl(final CustomerProvisionService customerProvisionService) {
        this.customerProvisionService = customerProvisionService;
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<CUSTOMERPROVISIONRESPONSE> customersProvision(@RequestBody CUSTOMERPROVISIONREQUEST customerprovisionrequest) throws Exception{
        try {
            LOGGER.info("Customer request CreateUser=========== ");
            customerProvisionService.customersProvision(customerprovisionrequest);
            return new ResponseEntity<CUSTOMERPROVISIONRESPONSE>(customerProvisionService.customersProvision(
                    customerprovisionrequest), HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.info("Exception:  " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

}

