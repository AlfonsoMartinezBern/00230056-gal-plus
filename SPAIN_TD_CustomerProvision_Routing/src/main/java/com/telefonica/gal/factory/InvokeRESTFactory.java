package com.telefonica.gal.factory;

import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.mapper.CustomerProvisionRequestMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class InvokeRESTFactory {

    private final static CustomerProvisionRequestMapper CUSTOMER_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CustomerProvisionRequestMapper.class);

    public CUSTOMERPROVISIONRESPONSE invokeMiViewService(String url, CUSTOMERPROVISIONREQUEST request) {
        RestTemplate restTemplate = new RestTemplate();
        CUSTOMERPROVISIONRESPONSE result = new CUSTOMERPROVISIONRESPONSE();
        result.setCUSTOMERS(new com.telefonica.gal.customerProvision.response.CUSTOMERS());
        try {
            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                result.getCUSTOMERS().getCUSTOMER().add(restTemplate
                        .postForEntity(url ,new HttpEntity<>(customer), com.telefonica.gal.customerProvision.response.CUSTOMER.class).getBody());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

    }

    public CUSTOMERPROVISIONRESPONSE invokeTOPService(String url, CUSTOMERPROVISIONREQUEST request) {
        RestTemplate restTemplate = new RestTemplate();
        CUSTOMERPROVISIONRESPONSE result = new CUSTOMERPROVISIONRESPONSE();
        result.setCUSTOMERS(new com.telefonica.gal.customerProvision.response.CUSTOMERS());
        try {
            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                result.getCUSTOMERS().getCUSTOMER().add(restTemplate
                        .postForEntity(url ,new HttpEntity<>(CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer))
                                ,com.telefonica.gal.customerProvision.response.CUSTOMER.class).getBody());
            }
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return result;
        }
    }
}
