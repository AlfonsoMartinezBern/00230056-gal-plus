package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.interfaceWs;

import com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.exception.HttpErrorsCDBProvision;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.provisionApi.model.*;
import org.json.JSONException;
import org.json.JSONObject;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
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
    CDBProvisionRequest cdbProvisionRequest = new CDBProvisionRequest();
    private CUSTOMERS customers = new CUSTOMERS();

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    StringWriter sw = new StringWriter();
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

    RestTemplate restTemplate = new RestTemplate();

    public WsMiViewTv(T endPoint, T request, String adminCode) {
        this.endPoint = endPoint;
        this.request = request;
        this.adminCode = adminCode;
    }

    @Override
    public T invoke() {
        String responseOK = new String("");
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setErrorHandler(new HttpErrorsCDBProvision());

        InlineResponse400 result = new InlineResponse400();
        endpointTD = (Endpoint) endPoint;

        //url = endpointTD.getTargetEndpoint() + "/instances/" + adminCode + "/users";
        url = endpointTD.getTargetEndpoint() + "/cdbprovision/rest/provision/OTT/"+ adminCode;

        try {
            LOGGER.info("==== REQUEST MIVIEW -------> " + request + "\n");
            LOGGER.info("URL MiView ---> " + url);

            cdbProvisionRequest = (CDBProvisionRequest) request;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CDBProvisionRequest> requestEntity = new HttpEntity<>(cdbProvisionRequest, headers);

            //ResponseEntity<String> resultMiView = restTemplate.postForEntity(url, cdbProvisionRequest, String.class);
            ResponseEntity<String> resultMiView = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

            if (resultMiView.getStatusCode().value() == 201) {
                return (T) responseOK;
            } else {
                JSONObject jsonObject = new JSONObject(resultMiView.getBody());
                return (T) responseInfo(jsonObject.get("resultCode").toString(), jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(504);
            result.setResultDetail(e.getMessage());
            result.setResultText(e.getMessage());
            return (T) result;
        }
    }

    public String responseInfo(String errorCode, JSONObject jsonObject) throws JSONException {
        switch (errorCode.substring(3)) {
            case "401":
                InlineResponse401 response401 = new InlineResponse401();
                response401.setResultCode(Integer.valueOf(errorCode));
                response401.setResultDetail(jsonObject.get("resultDetail").toString());
                response401.setResultText(jsonObject.get("resultText").toString());
                return response401.toString();
            case "403":
                InlineResponse403 response403 = new InlineResponse403();
                response403.setResultCode(Integer.valueOf(errorCode));
                response403.setResultDetail(jsonObject.get("resultDetail").toString());
                response403.setResultText(jsonObject.get("resultText").toString());
                return response403.toString();
            case "404":
                InlineResponse404 response404 = new InlineResponse404();
                response404.setResultCode(Integer.valueOf(errorCode));
                response404.setResultDetail(jsonObject.get("resultDetail").toString());
                response404.setResultText(jsonObject.get("resultText").toString());
                return response404.toString();
            case "409":
                InlineResponse409 response409 = new InlineResponse409();
                response409.setResultCode(Integer.valueOf(errorCode));
                response409.setResultDetail(jsonObject.get("resultDetail").toString());
                response409.setResultText(jsonObject.get("resultText").toString());
                return response409.toString();
            case "500":
                InlineResponse500 response500 = new InlineResponse500();
                response500.setResultCode(Integer.valueOf(errorCode));
                response500.setResultDetail(jsonObject.get("resultDetail").toString());
                response500.setResultText(jsonObject.get("resultText").toString());
                return response500.toString();
            case "4041":
                InlineResponse4041 response4041 = new InlineResponse4041();
                response4041.setResultCode(Integer.valueOf(errorCode));
                response4041.setResultDetail(jsonObject.get("resultDetail").toString());
                response4041.setResultText(jsonObject.get("resultText").toString());
                return response4041.toString();
            default:
                InlineResponse400 response504 = new InlineResponse400();
                response504.setResultCode(Integer.valueOf(errorCode));
                response504.setResultDetail(jsonObject.get("resultDetail").toString());
                response504.setResultText(jsonObject.get("resultText").toString());
                return response504.toString();
        }
    }

}
