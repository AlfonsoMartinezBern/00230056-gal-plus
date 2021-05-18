package com.telefonica.gal.interfaceWs.wsMiView;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.interfaceWs.InvokeWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WsMiViewTv<T> implements InvokeWs<T> {

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

    public WsMiViewTv(T endPoint, T request) {
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
            /*for (CUSTOMER customer : customerRequest.getCUSTOMERS().getCUSTOMER()) {
                url= "https://6e8314e8-78d3-4e90-8f83-ae4a7b519b6b.mock.pstmn.io/CDB_CustomerProvision_XML.php";
                result.getCUSTOMERS().getCUSTOMER().add(restTemplate
                        .postForEntity(url, new HttpEntity<>(customer), com.telefonica.gal.customerProvision.response.CUSTOMER.class).getBody());
            }*/
            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }
}
