package com.telefonica.gal.interfaceWs;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.dto.LogInfo;
import com.telefonica.gal.dto.LogInfoOpPlus;
import com.telefonica.gal.dto.MessageInfo;
import com.telefonica.gal.dto.ServiceInfoDto;
import com.telefonica.gal.exception.HttpErrors;
import com.telefonica.gal.logs.ConsolidationServiceMessage;
import com.telefonica.gal.mapper.ServicesConsolidationRequestMapper;
import com.telefonica.gal.provisionApi.model.Error;
import com.telefonica.gal.provisionApi.model.User;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.SERVICESCONSOLIDATIONREQUEST;
import com.telefonica.gal.servicesConsolidation.response.CUSTOMERS;
import com.telefonica.gal.servicesConsolidation.response.SERVICESCONSOLIDATIONRESPONSE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WsTopPlus<T> implements InvokeWs<T> {
    //private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());
    private static Logger loggerWithCustomLayout = LogManager.getLogger("LOGS_OP");

    private static final Integer ResponseCodeOK = 200;

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

    private ErrorResponse errorResponse;

    private ErrorKey errorKey;

    private ServiceInfoDto serviceInfoDto;

    private LogInfoOpPlus logInfoOpPlus;

    private MessageInfo messageInfo;

    @Autowired
    private User user;

    private Spain_TD_Error_Client iSpainTDError;

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
            for (CUSTOMER customer : servicesconsolidationrequest.getCUSTOMERS().getCUSTOMER()) {
                user = SERVICES_CONSOLIDATION_REQUEST_MAPPER.servicesConsolidationMapper(customer);
                URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" +
                        user.getUniqueId() +"/products";

                customerResponse = invokeTop(URL, customer, user);

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
                                                                                 final User userJson) throws JAXBException {
            String codeOperation = customerXml.getLISTTVSERVICES().getTVSERVICE().get(0).getTVSERVICEOPER().toString();

            com.telefonica.gal.servicesConsolidation.response.CUSTOMER customerResponse =
                    new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();

            Error error = new Error();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<User> requestEntity = new HttpEntity<>(userJson, headers);

        try {

            ResponseEntity<String> responseEntity = restTemplate
                    .exchange(url,
                            HttpMethod.PUT,
                            requestEntity,
                            String.class);

            if(responseEntity.getStatusCode().value() == ResponseCodeOK) {
                customerResponse = responseInfo("0");
            } else {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                String codeError = jsonObject.get("statusCode").toString();
                customerResponse = responseInfo(codeError);
            }

            customerResponse.setUSERID(customerXml.getUSERID());
            customerResponse.setOPERATIONID(customerXml.getOPERATIONID());

            generateLogs(customerXml,userJson, responseEntity.getBody(), customerResponse,URL, String.valueOf(endpointTD.getInstanceID()));

            return customerResponse;

        } catch (HttpClientErrorException | JAXBException e) {
            throw e;
        }

    }

    public com.telefonica.gal.servicesConsolidation.response.CUSTOMER responseInfo(String errorCode) {
        com.telefonica.gal.servicesConsolidation.response.CUSTOMER responseCustomer = new com.telefonica.gal.servicesConsolidation.response.CUSTOMER();
        errorKey = new ErrorKey(errorCode);

        iSpainTDError = new Spain_TD_Error_Client();

        errorResponse= iSpainTDError.search(errorKey);
        responseCustomer.setRESULTCODE(new BigInteger(errorResponse.getErrorInfo().getErrorCode()));
        responseCustomer.setDESCRIPTION(errorResponse.getErrorInfo().getErrorDescription());

        return responseCustomer;
    }

    private void generateLogs(final CUSTOMER request,
                              final User user,
                              final String responseEntity,
                              final com.telefonica.gal.servicesConsolidation.response.CUSTOMER response,
                              final String url,
                              final String instancedId) throws JAXBException {
        Map<String, String> indexKey = new HashMap<String, String>();
        logInfoOpPlus = new LogInfoOpPlus();
        messageInfo = new MessageInfo();
        serviceInfoDto = new ServiceInfoDto("SPAIN_TD_ServicesConsolidation");

        //XML
        JAXBContext jaxbContext = JAXBContext.newInstance(SERVICESCONSOLIDATIONREQUEST.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        String xmlString;

        jaxbMarshaller.marshal(request, sw);
        xmlString = sw.toString();

        indexKey.put("InstancedId", instancedId);
        indexKey.put("UniquedId", request.getUSERID());

        messageInfo.setMessageOriginalFormat(MediaType.APPLICATION_JSON.toString());
        messageInfo.setIndexKey(indexKey);
        messageInfo.setUrl(url);

        logInfoOpPlus.setIdLog(UUID.randomUUID().toString());
        logInfoOpPlus.setServiceInfo(serviceInfoDto);
        logInfoOpPlus.setMessageInfo(messageInfo);
        logInfoOpPlus.setRequest(xmlString);
        logInfoOpPlus.setTransformationRequest(new ConsolidationServiceMessage(user).getFormattedMessage().replace("\\",""));
        logInfoOpPlus.setResponse(responseEntity);
        logInfoOpPlus.setTransformationResponse(new ConsolidationServiceMessage(response).getFormattedMessage().replace("\\",""));

        loggerWithCustomLayout.info(logInfoOpPlus);

    }

}
