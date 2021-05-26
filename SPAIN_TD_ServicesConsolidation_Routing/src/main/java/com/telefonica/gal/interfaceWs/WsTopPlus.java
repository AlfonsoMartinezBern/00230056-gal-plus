package com.telefonica.gal.interfaceWs;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.exception.HttpErrors;
import com.telefonica.gal.mapper.ServicesConsolidationRequestMapper;
import com.telefonica.gal.provisionApi.model.Error;
import com.telefonica.gal.provisionApi.model.User;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.CUSTOMERS;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class WsTopPlus<T> implements InvokeWs<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

    private final static ServicesConsolidationRequestMapper SERVICES_CONSOLIDATION_REQUEST_MAPPER = Mappers.getMapper(
            ServicesConsolidationRequestMapper.class);

    private T endPoint;
    private T request;
    private String URL;

    private RestTemplate restTemplate = new RestTemplate();
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    private StringWriter sw = new StringWriter();
    private SERVICESCONSOLIDATIONRESPONSE response = new SERVICESCONSOLIDATIONRESPONSE();
    private com.telefonica.gal.servicesConsolidation.response.CUSTOMER customerResponse = new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();
    private CUSTOMERS customersResponses = new CUSTOMERS();

    @Autowired
    private SERVICESCONSOLIDATIONREQUEST servicesconsolidationrequest;

    @Autowired
    private Endpoint endpointTD;

    @Autowired
    private User user;

    public WsTopPlus(T endPoint, T request) {
        this.endPoint = endPoint;
        this.request = request;
    }

    @Override
    public T invoke() {
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setErrorHandler(new HttpErrors());

        servicesconsolidationrequest = (SERVICESCONSOLIDATIONREQUEST) request;
        endpointTD = (Endpoint) endPoint;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SERVICESCONSOLIDATIONREQUEST.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            String xmlString;

            for (CUSTOMER customer : servicesconsolidationrequest.getCUSTOMERS().getCUSTOMER()) {
                jaxbMarshaller.marshal(customer, sw);
                xmlString = sw.toString();
                LOGGER.info("==== REQUEST TOP -------> " + xmlString + "\n" );
                user = SERVICES_CONSOLIDATION_REQUEST_MAPPER.rervicesConsolidationMapper(customer);
                URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" +
                        user.getUniqueId() +"/products";

                LOGGER.info("URL TOP+     ---> " + URL);
                LOGGER.info("METODO REST: PUT   ");
                LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + user );

                customerResponse = invokeTop(URL, customer, user);

                LOGGER.info("============> Consolidación de paquetes TOP: OK. " );

                //Respuesta
                 customersResponses.getCUSTOMER().add(customerResponse);

            }
            response.setCUSTOMERS(customersResponses);

            return (T) response;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) response;
        }

    }

    private com.telefonica.gal.servicesConsolidation.response.CUSTOMER invokeTop(final String url, final CUSTOMER customerXml,
                                                                                 final User userJson) {

            com.telefonica.gal.servicesConsolidation.response.CUSTOMER customerResponse =
                    new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();

            Error error = new Error();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<User> requestEntity = new HttpEntity<>(userJson, headers);

        try {

            customerResponse.setUSERID(customerXml.getUSERID());
            customerResponse.setOPERATIONID(customerXml.getOPERATIONID());

            ResponseEntity<Object> responseEntity = restTemplate
                    .exchange(url,
                            HttpMethod.PUT,
                            requestEntity,
                            Object.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                customerResponse.setRESULTCODE(BigInteger.ZERO);
                customerResponse.setDESCRIPTION(HttpStatus.OK.toString());
            } else {
                customerResponse.setRESULTCODE(BigInteger.valueOf(responseEntity.getStatusCode().value()));
                customerResponse.setDESCRIPTION("KO");
            }

            return customerResponse;

        } catch (HttpClientErrorException e) {
            throw e;
        }

    }
}
