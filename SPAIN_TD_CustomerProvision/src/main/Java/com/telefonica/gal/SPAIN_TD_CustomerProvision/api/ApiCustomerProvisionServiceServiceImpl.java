package com.telefonica.gal.SPAIN_TD_CustomerProvision.api;

import com.telefonica.gal.SPAIN_TD_CustomerProvision.service.CustomerProvisionService;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerProvision")
public class ApiCustomerProvisionServiceServiceImpl implements ApiCustomerProvisionService {
    private final CustomerProvisionService customerProvisionService;

    public ApiCustomerProvisionServiceServiceImpl(CustomerProvisionService customerProvisionService) {
        this.customerProvisionService = customerProvisionService;
    }

    @Override
    @PostMapping(value="/createUser")
    public ResponseEntity<CUSTOMERPROVISIONRESPONSE> customersProvision(final @RequestBody CUSTOMERPROVISIONREQUEST customerprovisionrequest) {
        customerProvisionService.customersProvision(customerprovisionrequest);
        return new ResponseEntity<CUSTOMERPROVISIONRESPONSE>(customerProvisionService.customersProvision(
                customerprovisionrequest), HttpStatus.OK);
    }

}

