package com.telefonica.gal.SPAIN_TD_CDBProvision.api;

import com.telefonica.gal.SPAIN_TD_CDBProvision.service.CDBProvisionService;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cdbprovision/rest")
public class ApiCDBProvisionServiceImpl implements ApiCDBProvisionService {

    private final CDBProvisionService cdbProvisionService;

    public ApiCDBProvisionServiceImpl(CDBProvisionService cdbProvisionService) {
        this.cdbProvisionService = cdbProvisionService;
    }

    @Override
    @RequestMapping(value = "/provision/OTT/{adminCode}")
    public ResponseEntity<InlineResponse200> provisionOTTAdminCodePut(String adminCode, CDBProvisionRequest cdbProvisionRequest) {
        try {
            return new ResponseEntity<InlineResponse200>(cdbProvisionService.provisionOTTAdminCodePut(adminCode, cdbProvisionRequest), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
