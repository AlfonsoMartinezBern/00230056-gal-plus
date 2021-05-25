package com.telefonica.gal.interfaceWs.topplus;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.mapper.CustomerProvisionRequestMapper;
import com.telefonica.gal.mapper.CustomerProvisionResponseMapper;
import com.telefonica.gal.provisionApi.model.ResultOK;
import com.telefonica.gal.provisionApi.model.User;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;

public class WsTopPlus<T> implements InvokeWs<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

    private final static CustomerProvisionRequestMapper CUSTOMER_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CustomerProvisionRequestMapper.class);

    private final static CustomerProvisionResponseMapper CUSTOMER_PROVISION_RESPONSE_MAPPER = Mappers.getMapper(
            CustomerProvisionResponseMapper.class);

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

    //PRUEBAS
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

        customerRequest = (CUSTOMERPROVISIONREQUEST) request;
        endpointTD = (Endpoint) endPoint;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CUSTOMERPROVISIONREQUEST.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            String xmlString;

            for (CUSTOMER customer : customerRequest.getCUSTOMERS().getCUSTOMER()) {
                jaxbMarshaller.marshal(customer, sw);
                xmlString = sw.toString();
                LOGGER.info("==== REQUEST TOP -------> " + xmlString + "\n" );

                switch (customer.getOPERATIONTYPE()) {
                    case "ON":
                        requestON = new User();
                        requestON = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users";

                        LOGGER.info("URL TOP+     ---> " + URL);
                        LOGGER.info("METODO REST: postForEntity   ");
                        LOGGER.info("URL Original ------->  " + EVENT_ON);

                        LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + requestON );


                        ResponseEntity<ResultOK> resultTop = restTemplate.postForEntity(URL, requestON, ResultOK.class);

                        customerReponse = CUSTOMER_PROVISION_RESPONSE_MAPPER.transformationResponse(resultTop.getBody());


                        LOGGER.info("============> Alta de usuario TOP: OK. " );

                        //Respuesta
                        customers.getCUSTOMER().add(customerReponse);
                        break;

                    case "OFF":
                        String uniqueId = customer.getUSERID();
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + uniqueId;

                        LOGGER.info("URL TOP+     ---> " + URL);
                        LOGGER.info("METODO REST: DELETE   ");
                        LOGGER.info("URL Original ------->" + EVENT_OFF);

                        restTemplate.delete(URL, ResultOK.class);

                        LOGGER.info("============> Baja de usuario TOP: OK. " );
                        break;

                    case "MOD":
                        requestMOD = new User();
                        requestMOD = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + requestMOD.getUniqueId();

                        LOGGER.info("URL TOP+     ---> " + URL);
                        LOGGER.info("METODO REST: PUT   ");
                        LOGGER.info("URL Original ------->" + EVENT_MOD);

                        LOGGER.info("TRANSFORMACION PETICION MODIFICACION TOP ========>" + requestMOD );

                        restTemplate.put(URL, requestMOD);

                        LOGGER.info("============> Modificación de usuario TOP: OK. " );
                        break;

                    case "N":
                        requestN = new User();
                        requestN = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + requestN.getUniqueId() +"/move/start";

                        LOGGER.info("URL TOP+     --->  " + URL);
                        LOGGER.info("METODO REST: PUT   ");
                        LOGGER.info("URL Original ------->" + EVENT_TRASLADO);

                        LOGGER.info("TRANSFORMACION PETICION TRASLADO N TOP ========>  " + requestN );

                        restTemplate.put(URL, requestN);

                        LOGGER.info("============> Traslado OPERATION_TYPE = " + customer.getOPERATIONTYPE() + " de usuario OK. " );
                        break;


                    case "D":
                        requestD = new User();
                        requestD = CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer, endpointTD);
                        URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/"+ requestD.getUniqueId() +"/move/end";

                        LOGGER.info("URL TOP+     ---> " + URL);
                        LOGGER.info("METODO REST: PUT   ");
                        LOGGER.info("URL Original ------->" + EVENT_TRASLADO);

                        LOGGER.info("TRANSFORMACION PETICION TRASLADO D TOP ========>  " + requestD );

                        restTemplate.put(URL, requestD);

                        LOGGER.info("============> Traslado OPERATION_TYPE = " + customer.getOPERATIONTYPE() + " de usuario OK. " );
                        break;

                    default:
                        LOGGER.info("============> Unknown. " );
                        break;
                }
            }
            result.setCUSTOMERS(customers);

            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

   /* private HashMap<String, Integer> getPathParams(int instanceId, Optional<String> optinalParameter) {
        try {
            HashMap<String, Integer> queryParams = new HashMap<>();
            queryParams.put("instanceId", instanceId);
            //optinalParameter.ifPresent((uniqueId) -> queryParams.put("uniqueId", (T) String.valueOf(uniqueId)));
            LOGGER.info(" ==== > getPathParams");
            return queryParams;
        } catch (Exception e) {
            throw e;
        }
    }

    private HashMap<String, String> getPathParamsTraslado(int instanceId, Optional<String> paramsUniqueId,
                                                          Optional<String> paramsAction) {
        try {
            HashMap<String, String> queryParams = new HashMap<>();
            queryParams.put("instanceId", String.valueOf(instanceId));
            paramsUniqueId.ifPresent((uniqueId) -> queryParams.put("uniqueId", uniqueId));
            paramsAction.ifPresent((action) -> queryParams.put("action", action));
            LOGGER.info(" ==== > getPathParams");
            return queryParams;
        } catch (Exception e) {
            throw e;
        }
    }*/
}
