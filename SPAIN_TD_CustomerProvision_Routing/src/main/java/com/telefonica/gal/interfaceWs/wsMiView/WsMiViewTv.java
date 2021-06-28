package com.telefonica.gal.interfaceWs.wsMiView;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import com.telefonica.gal.dto.LogInfoCustomerMiView;
import com.telefonica.gal.dto.MessageInfoCustomer;
import com.telefonica.gal.dto.ServiceInfoCustomer;
import com.telefonica.gal.dto.customer.CustomerProvisionRequest;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.logs.CustomerServiceMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WsMiViewTv<T> implements InvokeWs<T> {

    private static Logger loggerCustomer = LogManager.getLogger("LOGS_CUSTOMER_V1");

    @Autowired
    CustomerProvisionRequest customerRequest;

    @Autowired
    Endpoint endpointTD;

    private MessageInfoCustomer messageInfoCustomer;
    private LogInfoCustomerMiView logInfoCustomerMiView;
    private ServiceInfoCustomer serviceInfoCustomer;

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
    StringWriter sw = new StringWriter();

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
        customerRequest = (CustomerProvisionRequest) request;
        endpointTD = (Endpoint) endPoint;
        url = endpointTD.getTargetEndpoint();
        try {

            ResponseEntity<CUSTOMERPROVISIONRESPONSE> resultMiView = restTemplate.postForEntity(
                    url, customerRequest, CUSTOMERPROVISIONRESPONSE.class);

            result = resultMiView.getBody();

            generateLogs(customerRequest, result, url, String.valueOf(endpointTD.getInstanceID()));

            return (T) result;

        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

    private void generateLogs(final CustomerProvisionRequest request,
                              final CUSTOMERPROVISIONRESPONSE response,
                              final String url,
                              final String instancedId) {
        Map<String, String> indexKey = new HashMap<String, String>();
        logInfoCustomerMiView = new LogInfoCustomerMiView();
        messageInfoCustomer = new MessageInfoCustomer();
        serviceInfoCustomer = new ServiceInfoCustomer("SPAIN_TD_CustomerProvision");

        indexKey.put("InstancedId", instancedId);
        indexKey.put("UniquedId", request.getCustomers().getCustomer().get(0).getUserid());

        messageInfoCustomer.setMessageOriginalFormat(MediaType.TEXT_HTML.toString());
        messageInfoCustomer.setIndexKey(indexKey);
        messageInfoCustomer.setUrl(url);

        logInfoCustomerMiView.setIdLog(UUID.randomUUID().toString());
        logInfoCustomerMiView.setServiceInfo(serviceInfoCustomer);
        logInfoCustomerMiView.setMessageInfo(messageInfoCustomer);
        logInfoCustomerMiView.setRequest(new CustomerServiceMessage(request).getFormattedMessage().replace("\\",""));
        logInfoCustomerMiView.setResponse(new CustomerServiceMessage(response).getFormattedMessage().replace("\\",""));
        loggerCustomer.info(logInfoCustomerMiView);

    }
}
