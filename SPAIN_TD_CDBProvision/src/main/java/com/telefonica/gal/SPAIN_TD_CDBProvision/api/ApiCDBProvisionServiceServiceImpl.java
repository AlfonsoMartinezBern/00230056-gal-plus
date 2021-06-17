package com.telefonica.gal.SPAIN_TD_CDBProvision.api;

import com.telefonica.gal.SPAIN_TD_CDBProvision.service.CDBProvisionService;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.InlineResponse200;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

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
    @PutMapping("/provision/OTT/{adminCode}")
    public ResponseEntity<InlineResponse200> provisionOTTAdminCodePut(@RequestParam String adminCode, @RequestBody CDBProvisionRequest cdbProvisionRequest) throws Exception{
        try {
            LOGGER.info("Customer request CreateUser=========== ");

            JAXBContext jaxbContext = JAXBContext.newInstance(CDBProvisionRequest.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return new ResponseEntity<InlineResponse200>(cdbProvisionService.provisionOTTAdminCodePut(adminCode, cdbProvisionRequest), HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.info("Exception:  " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}

