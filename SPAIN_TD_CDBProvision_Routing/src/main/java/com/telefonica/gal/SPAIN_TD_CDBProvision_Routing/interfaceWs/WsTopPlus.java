package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.interfaceWs;


import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.exception.HttpErrorsCDBProvision;
import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.mapper.CDBProvisionRequestMapper;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.td.error.facade.ISpainTDError;
import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.provisionApi.model.*;
import org.json.JSONException;
import com.telefonica.gal.provisionApi.model.User;
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
import java.util.Arrays;
import java.math.BigInteger;

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
    private T cdbrequest;
    private String adminCode;
    private T serviceID;
    private String URL;

    // Endpoint
    private final String CREATE_USER = "/instances/{instanceID}/users";

    private InlineResponse200 result = new InlineResponse200();
    //private com.telefonica.gal.customerProvision.response.CUSTOMER customerReponse =
    //       new com.telefonica.gal.customerProvision.response.CUSTOMER();
    private User request = new User();

    //PRUEBAS
    RestTemplate restTemplate = new RestTemplate();
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    StringWriter sw = new StringWriter();

    public WsTopPlus(T endPoint, T request, String adminCode) {
        this.endPoint = endPoint;
        this.cdbrequest = request;
        this.adminCode = adminCode;
    }

    @Override
    public T invoke() {
        String responseOK = new String("");
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setErrorHandler(new HttpErrorsCDBProvision());

        cdbProvisionRequest = (CDBProvisionRequest) cdbrequest;
        endpointTD = (Endpoint) endPoint;

        try {
            LOGGER.info("==== REQUEST TOP -------> " + cdbrequest + "\n");

            request = CDB_PROVISION_REQUEST_MAPPER.userDataMapper(cdbProvisionRequest, adminCode);
            URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users";

            LOGGER.info("URL TOP+     ---> " + URL);
            LOGGER.info("METODO REST: postForEntity   ");
            LOGGER.info("URL Original ------->  " + CREATE_USER);

            LOGGER.info("TRANSFORMACION PETICION CREATE TOP ========> " + request);

            ResponseEntity<String> resultTop = restTemplate.postForEntity(URL, request, String.class);

            if (resultTop.getStatusCode().value() == ResponseCodeOK) {
                return (T) responseOK;
            } else {
                JSONObject jsonObject = new JSONObject(resultTop.getBody());
                String codeError = jsonObject.get("statusCode").toString();
                return (T) responseInfoError(codeError, jsonObject);
            }


        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

    public String responseInfoError(String errorCode, JSONObject jsonObject) throws JSONException {
        switch (errorCode.substring(3)) {
            case "401":
                InlineResponse401 response401 = new InlineResponse401();
                response401.setResultCode(Integer.valueOf(errorCode));
                response401.setResultDetail(jsonObject.get("statusDetail").toString());
                response401.setResultText(jsonObject.get("statusMessage").toString());
                return response401.toString();
            case "403":
                InlineResponse403 response403 = new InlineResponse403();
                response403.setResultCode(Integer.valueOf(errorCode));
                response403.setResultDetail(jsonObject.get("statusDetail").toString());
                response403.setResultText(jsonObject.get("statusMessage").toString());
                return response403.toString();
            case "404":
                InlineResponse404 response404 = new InlineResponse404();
                response404.setResultCode(Integer.valueOf(errorCode));
                response404.setResultDetail(jsonObject.get("statusDetail").toString());
                response404.setResultText(jsonObject.get("statusMessage").toString());
                return response404.toString();
            case "409":
                InlineResponse409 response409 = new InlineResponse409();
                response409.setResultCode(Integer.valueOf(errorCode));
                response409.setResultDetail(jsonObject.get("statusDetail").toString());
                response409.setResultText(jsonObject.get("statusMessage").toString());
                return response409.toString();
            case "500":
                InlineResponse500 response500 = new InlineResponse500();
                response500.setResultCode(Integer.valueOf(errorCode));
                response500.setResultDetail(jsonObject.get("statusDetail").toString());
                response500.setResultText(jsonObject.get("statusMessage").toString());
                return response500.toString();
            case "4041":
                InlineResponse4041 response4041 = new InlineResponse4041();
                response4041.setResultCode(Integer.valueOf(errorCode));
                response4041.setResultDetail(jsonObject.get("statusDetail").toString());
                response4041.setResultText(jsonObject.get("statusMessage").toString());
                return response4041.toString();
            default:
                InlineResponse400 response504 = new InlineResponse400();
                response504.setResultCode(Integer.valueOf(errorCode));
                response504.setResultDetail(jsonObject.get("statusDetail").toString());
                response504.setResultText(jsonObject.get("statusMessage").toString());
                return response504.toString();
        }
    }
}
