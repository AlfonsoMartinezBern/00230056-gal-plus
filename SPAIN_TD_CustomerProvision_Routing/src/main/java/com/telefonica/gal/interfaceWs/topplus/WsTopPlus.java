package com.telefonica.gal.interfaceWs.topplus;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.mapper.CustomerProvisionRequestMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class WsTopPlus<T> implements InvokeWs<T> {

    private final static CustomerProvisionRequestMapper CUSTOMER_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CustomerProvisionRequestMapper.class);

    @Autowired
    CUSTOMERPROVISIONREQUEST customerRequest;

    @Autowired
    Endpoint endpointTD;

    private int instanceId;
    private int platformId;
    private String operationId;
    private String url;
    private T endPoint;
    private T request;
    private T response;
    private T serviceID;

    public WsTopPlus(T endPoint, T request) {
        this.endPoint = endPoint;
        this.request = request;
    }

    @Override
    public T invoke() {
        RestTemplate restTemplate = new RestTemplate();
        CUSTOMERPROVISIONRESPONSE result = new CUSTOMERPROVISIONRESPONSE();
        result.setCUSTOMERS(new com.telefonica.gal.customerProvision.response.CUSTOMERS());
        customerRequest = (CUSTOMERPROVISIONREQUEST) request;
        endpointTD = (Endpoint) endPoint;
        try {
            for (CUSTOMER customer : customerRequest.getCUSTOMERS().getCUSTOMER()) {
                switch (customer.getOPERATIONTYPE()) {
                    case "ON":
                        result.getCUSTOMERS().getCUSTOMER().add(restTemplate
                                .postForEntity(endpointTD.getTargetEndpoint(), new HttpEntity<>(CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer))
                                        , com.telefonica.gal.customerProvision.response.CUSTOMER.class).getBody());
                    case "OFF":
                        restTemplate.delete(url, new HttpEntity<>(customer), com.telefonica.gal.customerProvision.response.CUSTOMER.class);
                    case "MOD":
                        restTemplate.put(url, new HttpEntity<>(customer), com.telefonica.gal.customerProvision.response.CUSTOMER.class);
                    case "Traslado":
                        restTemplate.put(url, new HttpEntity<>(customer), com.telefonica.gal.customerProvision.response.CUSTOMER.class);
                    default:
                }
            }
            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }
}
