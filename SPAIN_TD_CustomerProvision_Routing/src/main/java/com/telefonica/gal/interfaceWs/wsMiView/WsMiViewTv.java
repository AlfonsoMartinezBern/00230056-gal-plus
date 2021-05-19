package com.telefonica.gal.interfaceWs.wsMiView;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.interfaceWs.topplus.WsTopPlus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class WsMiViewTv<T> implements InvokeWs<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

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
    private CUSTOMERS customers = new CUSTOMERS();

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<MediaType>();

    RestTemplate restTemplate = new RestTemplate();

    public WsMiViewTv(T endPoint, T request) {
        this.endPoint = endPoint;
        this.request = request;
    }

    @Override
    public T invoke() {
        mediaTypes.add(MediaType.TEXT_HTML);
        jaxbMessageConverter.setSupportedMediaTypes(mediaTypes);
        messageConverters.add(jaxbMessageConverter);

        restTemplate.setMessageConverters(messageConverters);

        CUSTOMERPROVISIONRESPONSE result = new CUSTOMERPROVISIONRESPONSE();
        result.setCUSTOMERS(new com.telefonica.gal.customerProvision.response.CUSTOMERS());
        customerRequest = (CUSTOMERPROVISIONREQUEST) request;
        endpointTD = (Endpoint) endPoint;
        url = endpointTD.getTargetEndpoint();
        try {

            LOGGER.info("PETICION MiView-> " + customerRequest);
            LOGGER.info("URL MiView --->" + url);

            ResponseEntity<CUSTOMERPROVISIONRESPONSE> resultMiView = restTemplate.postForEntity(
                    url, customerRequest, CUSTOMERPROVISIONRESPONSE.class);

            LOGGER.info("==== MiView: " + customerRequest.getCUSTOMERS().getCUSTOMER().get(0).getOPERATIONTYPE() + "  OK." );

            //Respuesta
            result = resultMiView.getBody();

            LOGGER.info("RESPUESTA MiVIew -> " + customerRequest);

            return (T) result;

        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }
}
