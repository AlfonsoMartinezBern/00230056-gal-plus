package com.telefonica.gal.interfaceWs.topplus;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.td.error.facade.ISpainTDError;
import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import com.telefonica.gal.dto.LogInfoCustomerOp;
import com.telefonica.gal.dto.MessageInfoCustomer;
import com.telefonica.gal.dto.ServiceInfoCustomer;
import com.telefonica.gal.dto.customer.Customer;
import com.telefonica.gal.dto.customer.CustomerProvisionRequest;
import com.telefonica.gal.exception.HttpErrorsCustomerProvision;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.logs.CustomerServiceMessage;
import com.telefonica.gal.mapper.CustomerProvisionRequestMapper;
import com.telefonica.gal.provisionApi.model.ResultOK;
import com.telefonica.gal.provisionApi.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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

    private static Logger loggerCustomer = LogManager.getLogger("LOGS_CUSTOMER_OP");
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

    private static final Integer ResponseCodeOK = 200;
    private static final String  codeResponseOK = "0";

    private final static CustomerProvisionRequestMapper CUSTOMER_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CustomerProvisionRequestMapper.class);

    CustomerProvisionRequest customerRequest = new CustomerProvisionRequest();

    @Autowired
    Endpoint endpointTD;

    private ISpainTDError iSpainTDError;

    @Autowired
    private ErrorResponse errorResponse;

    private ErrorKey errorKey;

    private int instanceId;
    private int platformId;
    private String operationId;
    private String url;
    private T endPoint;
    private T request;
    private T serviceID;
    private String URL;

    // Endpoint
    private final String EVENT_ON = "/instances/{instanceID}/users";
    private final String EVENT_MOD = " /instances/{instanceId}/users/{uniqueId}";
    private final String EVENT_OFF = "/instances/{instanceId}/users/{uniqueId}";
    private final String EVENT_TRASLADO = " /instances/{instanceId}/users/{uniqueId}/move/{action}";

    private CUSTOMERPROVISIONRESPONSE result = new CUSTOMERPROVISIONRESPONSE();
    private CUSTOMERS customers = new CUSTOMERS();
    private com.telefonica.gal.customerProvision.response.CUSTOMER customerReponse =
            new com.telefonica.gal.customerProvision.response.CUSTOMER();
    private User requestON = new User();
    private User requestMOD = new User();
    private User requestN = new User();
    private User requestD = new User();
    private User requestTraslado = new User();
    private User requestTrasladoND = new User();

    private LogInfoCustomerOp logInfoCustomerOp;
    private ServiceInfoCustomer serviceInfoCustomer;
    private MessageInfoCustomer messageInfoCustomer;

    RestTemplate restTemplate = new RestTemplate();
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    StringWriter sw = new StringWriter();


    public WsTopPlus(T endPoint, T request) {
        this.endPoint = endPoint;
        this.request = request;
    }

    @Override
    public T invoke() {
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setErrorHandler(new HttpErrorsCustomerProvision());

        customerRequest = (CustomerProvisionRequest) request;
        endpointTD = (Endpoint) endPoint;

        LOGGER.info("==== REQUEST TOP -------> " + customerRequest + "\n");

        try {
            for (Customer customer : customerRequest.getCustomers().getCustomer()) {

                switch (customer.getOperationtype()) {
                    case "ON":
                        requestON = new User();
                        requestON = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + requestON);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users";
                        LOGGER.info("URL TOP+     ---> " + URL);

                        ResponseEntity<String> resultTop = restTemplate.postForEntity(URL, requestON, String.class);
                        LOGGER.info("METODO REST: postForEntity   ");

                        if(resultTop.getStatusCode().value() == ResponseCodeOK) {
                            customerReponse = responseInfoError(codeResponseOK);
                        } else {
                            JSONObject jsonObject = new JSONObject(resultTop.getBody());
                            String codeError = jsonObject.get("statusCode").toString();
                            customerReponse = responseInfoError(codeError);
                        }

                        //Respuesta
                        customers.getCUSTOMER().add(customerReponse);
                        generateLogs(customer, requestON, resultTop.getBody(), customerReponse, URL, String.valueOf(endpointTD.getInstanceID()));

                        break;

                    case "OFF":
                        String uniqueId = customer.getUserid();
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + uniqueId;
                        LOGGER.info("UNIQUEID PETICION DELETE TOP ========> " + uniqueId);
                        LOGGER.info("URL TOP+     ---> " + URL);

                        restTemplate.delete(URL, ResultOK.class);
                        LOGGER.info("METODO REST: delete   ");

                        customerReponse = responseInfoError(codeResponseOK);

                        //Respuesta
                        customers.getCUSTOMER().add(customerReponse);
                        generateLogs(customer, requestON, null, customerReponse, URL, String.valueOf(endpointTD.getInstanceID()));

                        break;

                    case "MOD":
                        requestMOD = new User();
                        requestMOD = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        LOGGER.info("TRANSFORMACION PETICION MODIFICATION TOP ========> " + requestMOD);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + requestMOD.getUniqueId();
                        LOGGER.info("URL TOP+     ---> " + URL);

                        restTemplate.put(URL, requestMOD);
                        LOGGER.info("METODO REST: put   ");

                        customerReponse = responseInfoError(codeResponseOK);

                        //Respuesta
                        customers.getCUSTOMER().add(customerReponse);
                        generateLogs(customer, requestON, null, customerReponse, URL, String.valueOf(endpointTD.getInstanceID()));

                        break;

                    case "N":
                        requestN = new User();
                        requestN = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + requestN);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + requestN.getUniqueId() +"/move/start";
                        LOGGER.info("URL TOP+     ---> " + URL);

                        restTemplate.put(URL, requestN);
                        LOGGER.info("METODO REST: put   ");

                        customerReponse = responseInfoError(codeResponseOK);

                        //Respuesta
                        customers.getCUSTOMER().add(customerReponse);
                        generateLogs(customer, requestON, null, customerReponse, URL, String.valueOf(endpointTD.getInstanceID()));
                        break;


                    case "D":
                        requestD = new User();
                        requestD = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + requestD);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/"+ requestD.getUniqueId() +"/move/end";
                        LOGGER.info("URL TOP+     ---> " + URL);

                        restTemplate.put(URL, requestD);
                        LOGGER.info("METODO REST: put   ");

                        customerReponse = responseInfoError(codeResponseOK);

                        //Respuesta
                        customers.getCUSTOMER().add(customerReponse);
                        generateLogs(customer, requestON, null, customerReponse, URL, String.valueOf(endpointTD.getInstanceID()));
                        break;

                    default:
                        break;
                }

                customerReponse.setUSERID(customer.getUserid());
                customerReponse.setOPERATIONID(customer.getOperationid());
            }
            result.setCUSTOMERS(customers);

            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

    private com.telefonica.gal.customerProvision.response.CUSTOMER responseInfoError(String errorCode) {
        com.telefonica.gal.customerProvision.response.CUSTOMER responseCustomer = new com.telefonica.gal.customerProvision.response.CUSTOMER();
        errorKey = new ErrorKey(errorCode);
        iSpainTDError = new Spain_TD_Error_Client();

        errorResponse = iSpainTDError.search(errorKey);
        responseCustomer.setRESULTCODE(new BigInteger(errorResponse.getErrorInfo().getErrorCode()));
        responseCustomer.setDESCRIPTION(errorResponse.getErrorInfo().getErrorDescription());

        return responseCustomer;
    }

    private void generateLogs(final Customer request,
                              final User user,
                              final String responseEntity,
                              final com.telefonica.gal.customerProvision.response.CUSTOMER response,
                              final String url,
                              final String instancedId) throws JAXBException {
        Map<String, String> indexKey = new HashMap<String, String>();
        logInfoCustomerOp = new LogInfoCustomerOp();
        messageInfoCustomer = new MessageInfoCustomer();
        serviceInfoCustomer= new ServiceInfoCustomer("SPAIN_TD_CustomerProvision");

        //XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        String xmlString;

        jaxbMarshaller.marshal(request, sw);
        xmlString = sw.toString();

        indexKey.put("InstancedId", instancedId);
        indexKey.put("UniquedId", request.getUserid());

        messageInfoCustomer.setMessageOriginalFormat(MediaType.APPLICATION_JSON.toString());
        messageInfoCustomer.setIndexKey(indexKey);
        messageInfoCustomer.setUrl(url);

        logInfoCustomerOp.setIdLog(UUID.randomUUID().toString());
        logInfoCustomerOp.setServiceInfo(serviceInfoCustomer);
        logInfoCustomerOp.setMessageInfo(messageInfoCustomer);
        logInfoCustomerOp.setRequest(xmlString);
        logInfoCustomerOp.setTransformationRequest(new CustomerServiceMessage(user).getFormattedMessage().replace("\\",""));
        if (responseEntity != null) {
            logInfoCustomerOp.setResponse(responseEntity);
        }
        logInfoCustomerOp.setTransformationResponse(new CustomerServiceMessage(response).getFormattedMessage().replace("\\",""));

        loggerCustomer.info(logInfoCustomerOp);

    }
}
