package com.telefonica.gal.interfaceWs;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.exception.HttpErrors;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class WsMiViewTv<T> implements InvokeWs<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

    private String url;
    private T endPoint;
    private T request;

    private SERVICESCONSOLIDATIONREQUEST servicesconsolidationrequest;
    private Endpoint endpointTD;

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    StringWriter sw = new StringWriter();

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
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
        restTemplate.setErrorHandler(new HttpErrors());

        SERVICESCONSOLIDATIONRESPONSE result = new SERVICESCONSOLIDATIONRESPONSE();
        result.setCUSTOMERS(new com.telefonica.gal.servicesConsolidation.response.CUSTOMERS());
        servicesconsolidationrequest = (SERVICESCONSOLIDATIONREQUEST) request;
        endpointTD = (Endpoint) endPoint;
        url = endpointTD.getTargetEndpoint();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SERVICESCONSOLIDATIONREQUEST.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.marshal(servicesconsolidationrequest, sw);
            String xmlString = sw.toString();
            LOGGER.info("==== REQUEST MIVIEW -------> " + xmlString + "\n");
            LOGGER.info("URL MiView ---> " + url);

            ResponseEntity<SERVICESCONSOLIDATIONRESPONSE> resultMiView = restTemplate.postForEntity(
                    url, servicesconsolidationrequest, SERVICESCONSOLIDATIONRESPONSE.class);

            //Respuesta
            result = resultMiView.getBody();

            LOGGER.info("RESPUESTA MiVIew -> " + servicesconsolidationrequest);

            return (T) result;

        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }

    }
}
