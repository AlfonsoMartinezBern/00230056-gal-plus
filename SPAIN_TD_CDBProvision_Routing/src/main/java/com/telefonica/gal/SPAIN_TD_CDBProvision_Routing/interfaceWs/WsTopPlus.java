package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.interfaceWs;

import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.exception.HttpErrorsCustomerProvision;
import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.mapper.CDBProvisionRequestMapper;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.td.error.facade.ISpainTDError;
import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.provisionApi.model.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WsTopPlus<T> implements InvokeWs<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

    private static final Integer ResponseCodeOK = 200;
    private static final String codeResponseOK = "0";

    private final static CDBProvisionRequestMapper CDB_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CDBProvisionRequestMapper.class);


    @Autowired
    CDBProvisionRequest cdbProvisionRequest;

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
    private String adminCode;
    private T serviceID;
    private String URL;

    // Endpoint
    private final String CREATE_USER = "/instances/{instanceID}/users";

    private InlineResponse200 result = new InlineResponse200();
    //private com.telefonica.gal.customerProvision.response.CUSTOMER customerReponse =
    //       new com.telefonica.gal.customerProvision.response.CUSTOMER();
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


    public WsTopPlus(T endPoint, T request, String adminCode) {
        this.endPoint = endPoint;
        this.request = request;
        this.adminCode = adminCode;
    }

    @Override
    public T invoke() {
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setErrorHandler(new HttpErrorsCustomerProvision());

        cdbProvisionRequest = (CDBProvisionRequest) request;
        endpointTD = (Endpoint) endPoint;

        try {
            LOGGER.info("==== REQUEST TOP -------> " + request + "\n");

            requestON = CDB_PROVISION_REQUEST_MAPPER.userDataMapper(cdbProvisionRequest, adminCode);
            URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users";

            LOGGER.info("URL TOP+     ---> " + URL);
            LOGGER.info("METODO REST: postForEntity   ");
            LOGGER.info("URL Original ------->  " + CREATE_USER);

            LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + requestON);

            ResponseEntity<String> resultTop = restTemplate.postForEntity(URL, requestON, String.class);

            if (resultTop.getStatusCode().value() == ResponseCodeOK) {
                return (T) responseOK(resultTop);
            } else {
                JSONObject jsonObject = new JSONObject(resultTop.getBody());
                String codeError = jsonObject.get("statusCode").toString();
                return (T) responseInfoError(codeError);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

    public InlineResponse200 responseOK(ResponseEntity<String> resultMiView) throws JSONException {
        InlineResponse200 inlineResponse200 = new InlineResponse200();

        JSONObject jsonObject = new JSONObject(resultMiView.getBody());

        List<SubscribedProduct> items = new ArrayList<>();
        SubscribedProduct subscribedProduct= new SubscribedProduct();
        subscribedProduct.setCode(jsonObject.get("").toString());
        /*SubscribedProduct.StateEnum stateEnum = new SubscribedProduct.StateEnum();
        subscribedProduct.setState(jsonObject.get("").toString());
        subscribedProduct.setType(jsonObject.get("").toString());*/

        items.add(new SubscribedProduct());

        inlineResponse200.setItems(items);

        return inlineResponse200;
    }

    public T responseInfoError(String errorCode) {
        ErrorKey errorKey;
        Spain_TD_Error_Client iSpainTDError;
        ErrorResponse errorResponse;
        switch (errorCode) {
            case "400":
                InlineResponse400 response400 = new InlineResponse400();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response400.setResultCode(400);
                response400.setResultDetail(errorResponse.getResult());
                response400.setResultText(errorResponse.getMessage());
                return (T) response400;
            case "401":
                InlineResponse401 response401 = new InlineResponse401();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response401.setResultCode(401);
                response401.setResultDetail(errorResponse.getResult());
                response401.setResultText(errorResponse.getMessage());
                return (T) response401;
            case "403":
                InlineResponse403 response403 = new InlineResponse403();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response403.setResultCode(403);
                response403.setResultDetail(errorResponse.getResult());
                response403.setResultText(errorResponse.getMessage());
                return (T) response403;
            case "404":
                InlineResponse404 response404 = new InlineResponse404();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response404.setResultCode(404);
                response404.setResultDetail(errorResponse.getResult());
                response404.setResultText(errorResponse.getMessage());
                return (T) response404;
            case "409":
                InlineResponse409 response409 = new InlineResponse409();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response409.setResultCode(409);
                response409.setResultDetail(errorResponse.getResult());
                response409.setResultText(errorResponse.getMessage());
                return (T) response409;
            case "500":
                InlineResponse500 response500 = new InlineResponse500();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response500.setResultCode(500);
                response500.setResultDetail(errorResponse.getResult());
                response500.setResultText(errorResponse.getMessage());
                return (T) response500;
            case "4041":
                InlineResponse4041 response4041 = new InlineResponse4041();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response4041.setResultCode(4041);
                response4041.setResultDetail(errorResponse.getResult());
                response4041.setResultText(errorResponse.getMessage());
                return (T) response4041;
            default:
                InlineResponse400 response504 = new InlineResponse400();
                errorKey = new ErrorKey(errorCode);
                iSpainTDError = new Spain_TD_Error_Client();
                errorResponse = iSpainTDError.search(errorKey);
                response504.setResultCode(504);
                response504.setResultDetail(errorResponse.getResult());
                response504.setResultText(errorResponse.getMessage());
                return (T) response504;
        }
    }
}
