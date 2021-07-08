package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.interfaceWs.wsMiView;

import com.google.gson.Gson;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto.LogInfoHelpdesk;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto.MessageInfoHelpdesk;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto.ServiceInfoHelpdesk;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.wsdl.getProfile.GetProfileRequest;
import com.telefonica.gal.wsdl.getProfile.GetProfileResponse;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.description.OperationDesc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.util.*;

public class WsMiViewTv<T> implements InvokeWs<T> {
    private static Logger loggerHelpdesk = LogManager.getLogger("LOGS_HELPDESK_MIVIEW");

    private String url;
    private T endPoint;
    private T request;

    private GetProfileRequest getProfileRequest;
    private Endpoint endpointTD;

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    StringWriter sw = new StringWriter();

    private RestTemplate restTemplate = new RestTemplate();

    private ServiceInfoHelpdesk serviceInfoHelpdesk;

    private LogInfoHelpdesk logInfoHelpdesk;

    private MessageInfoHelpdesk messageInfoHelpdesk;

    private Vector headers = new Vector();
    private Vector attachments = new Vector();
    private OperationDesc[] _operations = new org.apache.axis.description.OperationDesc[7];

    public WsMiViewTv(T endPoint, T request) {
        this.endPoint = endPoint;
        this.request = request;
    }

    @Override
    public T invoke() {
        System.out.println("MiView");
        getProfileRequest = (GetProfileRequest) request;
        endpointTD = (Endpoint) endPoint;
        String endpoint = endpointTD.getTargetEndpoint();
        GetProfileResponse result = new GetProfileResponse();

        try {
            // SOAP CALL WITH AXIS 1.4
            Service service = new Service();
            _initOperationDesc1();
            System.out.printf(endpoint);
            Call call =  (Call) service.createCall();
            call.setTargetEndpointAddress( new java.net.URL(endpoint) );
            call.setOperation(_operations[3]);
            call.setUseSOAPAction(true);
            call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
            call.setOperationName(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "getProfile"));
            try {
                result = (GetProfileResponse) call.invoke(new java.lang.Object[] {getProfileRequest});
                generateLogs(getProfileRequest,
                        result,
                        null,
                        url,
                        String.valueOf(endpointTD.getInstanceID()));
            } catch (org.apache.axis.AxisFault axisFaultException) {
                axisFaultException.printStackTrace();
                System.out.println(axisFaultException.getMessage());
            }

            return (T) result;

        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }

    }


    private void generateLogs(final GetProfileRequest getProfileRequest,
                              final GetProfileResponse getProfileResponse,
                              final GetProfileResponse tranmsformedGetProfileResponse,
                              final String url,
                              final String instancedId) {
        Map<String, String> indexKey = new HashMap<String, String>();
        logInfoHelpdesk = new LogInfoHelpdesk(getProfileRequest, getProfileResponse, tranmsformedGetProfileResponse);
        messageInfoHelpdesk = new MessageInfoHelpdesk();
        serviceInfoHelpdesk= new ServiceInfoHelpdesk("SPAIN_TD_Helpdesk");

        indexKey.put("InstancedId", instancedId);
        indexKey.put("UniquedId", getProfileRequest.getCod_admin());

        messageInfoHelpdesk.setMessageOriginalFormat(MediaType.APPLICATION_JSON.toString());
        messageInfoHelpdesk.setIndexKey(indexKey);
        messageInfoHelpdesk.setUrl(url);

        logInfoHelpdesk.setIdLog(UUID.randomUUID().toString());
        logInfoHelpdesk.setServiceInfo(serviceInfoHelpdesk);
        logInfoHelpdesk.setMessageInfo(messageInfoHelpdesk);

        loggerHelpdesk.info(logInfoHelpdesk);

    }


    private void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("packagesChannels_Contracted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "packagesChannels_ContractedRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "PackagesChannels_ContractedRequest"), com.telefonica.gal.wsdl.getProfile.PackagesChannels_ContractedRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "PackagesChannels_ContractedResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.PackagesChannels_ContractedResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "packagesChannels_ContractedResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("servicesSubscription_Contracted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "servicesSubscription_ContractedRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "ServicesSubscription_ContractedRequest"), com.telefonica.gal.wsdl.getProfile.ServicesSubscription_ContractedRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "ServicesSubscription_ContractedResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.ServicesSubscription_ContractedResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "servicesSubscription_ContractedResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("voD_Bought");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "voD_BoughtRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "VoD_BoughtRequest"), com.telefonica.gal.wsdl.getProfile.VoD_BoughtRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "VoD_BoughtResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.VoD_BoughtResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "voD_BoughtResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProfile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "getProfileRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "getProfileRequest"), com.telefonica.gal.wsdl.getProfile.GetProfileRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "getProfileResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.GetProfileResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProfileResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "getUserIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "getUserIdRequest"), com.telefonica.gal.wsdl.getProfile.GetUserIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "getUserIdResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.GetUserIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUserIdResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ms_packagesChannels_Contracted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "packagesChannels_ContractedRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "PackagesChannels_ContractedRequest"), com.telefonica.gal.wsdl.getProfile.PackagesChannels_ContractedRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "MS_PackagesChannels_ContractedResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.MS_PackagesChannels_ContractedResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "packagesChannels_ContractedResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ms_getProfile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "getProfileRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "getProfileRequest"), com.telefonica.gal.wsdl.getProfile.GetProfileRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://CDBIF_LEGIF_SIGAHD.MiViewTV", "MS_getProfileResponse"));
        oper.setReturnClass(com.telefonica.gal.wsdl.getProfile.MS_getProfileResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProfileResponse"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

    }
}
