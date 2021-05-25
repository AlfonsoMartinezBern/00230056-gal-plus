package com.telefonica.gal.api;

import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/consolidationService")
public class ApiConsolidationServiceImpl implements ApiConsolidationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiConsolidationServiceImpl.class);

    @Override
    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public SERVICESCONSOLIDATIONRESPONSE consolidationPackage(@RequestBody SERVICESCONSOLIDATIONREQUEST request) {
        LOGGER.info("CONSOLIDATION SERVICE ============");
        return null;
    }
}
