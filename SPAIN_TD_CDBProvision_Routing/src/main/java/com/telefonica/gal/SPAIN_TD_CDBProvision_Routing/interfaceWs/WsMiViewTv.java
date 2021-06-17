package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.interfaceWs;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.provisionApi.model.*;
import org.json.JSONException;
import org.json.JSONObject;
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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class WsMiViewTv<T> implements InvokeWs<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WsTopPlus.class.getName());

    @Autowired
    Endpoint endpointTD;

    private int instanceId;
    private int platformId;
    private String operationId;
    private String url;
    private String adminCode;
    private T endPoint;
    private T request;
    private T response;
    private T serviceID;

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    StringWriter sw = new StringWriter();

    RestTemplate restTemplate = new RestTemplate();

    public WsMiViewTv(T endPoint, T request, String adminCode) {
        this.endPoint = endPoint;
        this.request = request;
        this.adminCode = adminCode;
    }

    @Override
    public T invoke() {
        mediaTypes.add(MediaType.TEXT_HTML);
        jaxbMessageConverter.setSupportedMediaTypes(mediaTypes);
        messageConverters.add(jaxbMessageConverter);

        restTemplate.setMessageConverters(messageConverters);

        InlineResponse400 result = new InlineResponse400();
        endpointTD = (Endpoint) endPoint;
        url = endpointTD.getTargetEndpoint() + "/instances/" + adminCode + "/users";
        try {
            LOGGER.info("==== REQUEST MIVIEW -------> " + request + "\n");
            LOGGER.info("URL MiView ---> " + url);

            ResponseEntity<String> resultMiView = restTemplate.postForEntity(
                    url, request, String.class);

            if (resultMiView.getStatusCode().value() == 200) {
                return (T) responseOK(resultMiView);
            } else {
                JSONObject jsonObject = new JSONObject(resultMiView.getBody());
                String codeError = jsonObject.get("statusCode").toString();
                return (T) responseInfo(codeError, jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

    public InlineResponse200 responseOK(ResponseEntity<String> resultMiView) throws JSONException {
        InlineResponse200 inlineResponse200 = new InlineResponse200();

        JSONObject jsonObject = new JSONObject(resultMiView.getBody());

        return inlineResponse200;
    }

    public T responseInfo(String errorCode, JSONObject jsonObject) throws JSONException {
        switch (errorCode) {
            case "400":
                InlineResponse400 response400 = new InlineResponse400();
                response400.setResultCode(400);
                response400.setResultDetail(jsonObject.get("resultDetail").toString());
                response400.setResultText(jsonObject.get("resultText").toString());
                return (T) response400;
            case "401":
                InlineResponse401 response401 = new InlineResponse401();
                response401.setResultCode(401);
                response401.setResultDetail(jsonObject.get("resultDetail").toString());
                response401.setResultText(jsonObject.get("resultText").toString());
                return (T) response401;
            case "403":
                InlineResponse403 response403 = new InlineResponse403();
                response403.setResultCode(403);
                response403.setResultDetail(jsonObject.get("resultDetail").toString());
                response403.setResultText(jsonObject.get("resultText").toString());
                return (T) response403;
            case "404":
                InlineResponse404 response404 = new InlineResponse404();
                response404.setResultCode(404);
                response404.setResultDetail(jsonObject.get("resultDetail").toString());
                response404.setResultText(jsonObject.get("resultText").toString());
                return (T) response404;
            case "409":
                InlineResponse409 response409 = new InlineResponse409();
                response409.setResultCode(409);
                response409.setResultDetail(jsonObject.get("resultDetail").toString());
                response409.setResultText(jsonObject.get("resultText").toString());
                return (T) response409;
            case "500":
                InlineResponse500 response500 = new InlineResponse500();
                response500.setResultCode(500);
                response500.setResultDetail(jsonObject.get("resultDetail").toString());
                response500.setResultText(jsonObject.get("resultText").toString());
                return (T) response500;
            case "4041":
                InlineResponse4041 response4041 = new InlineResponse4041();
                response4041.setResultCode(4041);
                response4041.setResultDetail(jsonObject.get("resultDetail").toString());
                response4041.setResultText(jsonObject.get("resultText").toString());
                return (T) response4041;
            default:
                InlineResponse400 response504 = new InlineResponse400();
                response504.setResultCode(504);
                response504.setResultDetail(jsonObject.get("resultDetail").toString());
                response504.setResultText(jsonObject.get("resultText").toString());
                return (T) response504;
        }
    }
}
