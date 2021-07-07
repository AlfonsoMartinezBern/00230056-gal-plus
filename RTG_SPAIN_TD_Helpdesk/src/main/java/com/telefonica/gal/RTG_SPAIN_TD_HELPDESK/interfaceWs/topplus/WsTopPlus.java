package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.interfaceWs.topplus;


import com.google.gson.Gson;

import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto.LogInfoHelpdesk;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto.MessageInfoHelpdesk;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto.ServiceInfoHelpdesk;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.exception.HttpsErrorsHelpdesk;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.mapper.GetProfileResposeMapper;
import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.utils.ErrorCodeEnum;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.spain.td.error.facade.ISpainTDError;
import com.telefonica.gal.client.spain.td.error.facade.Spain_TD_Error_Client;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.provisionApi.model.UserResponse;
import com.telefonica.gal.wsdl.getProfile.*;
import com.telefonica.gal.wsdl.getProfile.Error;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class WsTopPlus<T> implements InvokeWs<T> {
    private static Logger loggerHelpdesk = LogManager.getLogger("LOGS_HELPDESK_OP");

    // REQUEST HANDLING
    private RestTemplate restTemplate = new RestTemplate();
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    private GetProfileRequest getProfileRequest;
    private Endpoint endpointTD;
    private String URL;

    // RESPONSE STATUS CODES FROM TOP+
//    private static final Integer RESPONSE_CODE_OK = 200;
//    private static final  Integer RESPONSE_CODE_NOT_FOUND = 404;
//    private static final Integer RESPONSE_CODE_SERVICE_UNAVAILABLE = 503;

    // RESPONSE TEXT
    private static final String  COD_DIAGNOSTICO = "PGIM.0007.D0001";
    private static final String TEXTO_DIAGNOSTICO = "OK";

    private final static GetProfileResposeMapper GETPROFILE_RESPONSE_MAPPER = Mappers.getMapper(
            GetProfileResposeMapper.class);

    private ISpainTDError iSpainTDError;

    private int instanceId;
    private int platformId;
    private String orden_hidra;
    private String url;
    private T endPoint;
    private T request;
    private T serviceID;

    private LogInfoHelpdesk logInfoHelpdesk;
    private ServiceInfoHelpdesk serviceInfoHelpdesk;
    private MessageInfoHelpdesk messageInfoHelpdesk;

    private GetProfileResponse result = new GetProfileResponse();

    public WsTopPlus(T endPoint, T request) {
        this.endPoint = endPoint;
        this.request = request;
    }

    @Override
    public T invoke() {
        System.out.println("TOP+");

        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setErrorHandler(new HttpsErrorsHelpdesk());

        getProfileRequest = (GetProfileRequest) request;
        endpointTD = (Endpoint) endPoint;

        try {
            Boolean includeInternalProducts = getProfileRequest.getInclude_internal_products();
            if (includeInternalProducts != null)
                URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + getProfileRequest.getCod_admin()+ "?includeInternalProducts=" + includeInternalProducts;
            else
                URL = endpointTD.getTargetEndpoint() + "/instances/" + endpointTD.getInstanceID() + "/users/" + getProfileRequest.getCod_admin()+ "?includeInternalProducts=" + includeInternalProducts;

            System.out.println(URL);
            ResponseEntity<UserResponse> resultTop = restTemplate.getForEntity(URL, UserResponse.class);

            Gson gson = new Gson();
            result = GETPROFILE_RESPONSE_MAPPER.mapTOPResponse(resultTop.getBody());
            result.setOrden_hidra(getProfileRequest.getOrden_hidra());

            int statusCode = resultTop.getStatusCode().value();
            switch (statusCode) {
                case 404:
                    Error error_0006 = responseInfoError(ErrorCodeEnum.NOT_EXIST_CLIENT_IDENTIFIER.getValue());
                    HidraTypeResult hidraTypeResult_006 = new HidraTypeResult();
                    hidraTypeResult_006.setError(error_0006);

                    result.setHidra_type_result(hidraTypeResult_006);
                    result.setCustomer_profile(null);

                    generateLogs(getProfileRequest, null, result, URL, String.valueOf(endpointTD.getInstanceID()));
                    break;
                case 503:
                    Error error_0008 = responseInfoError(ErrorCodeEnum.COMMUNICATIONS_ERROR.getValue());
                    HidraTypeResult hidraTypeResult_008 = new HidraTypeResult();
                    hidraTypeResult_008.setError(error_0008);

                    result.setHidra_type_result(hidraTypeResult_008);
                    result.setCustomer_profile(null);

                    generateLogs(getProfileRequest, null, result, URL, String.valueOf(endpointTD.getInstanceID()));
                    break;
                default:
                case 200:
                    Diagnostico diagnostico = new Diagnostico();
                    diagnostico.setTexto_diagnostico(TEXTO_DIAGNOSTICO);
                    diagnostico.setCod_diagnostico(COD_DIAGNOSTICO);

                    HidraTypeResult hidraTypeResult = new HidraTypeResult();
                    hidraTypeResult.setDiagnostico(diagnostico);

                    result.setHidra_type_result(hidraTypeResult);

                    generateLogs(getProfileRequest, resultTop.getBody(), result, URL, String.valueOf(endpointTD.getInstanceID()));
                    break;
            }

            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
            return (T) result;
        }
    }

    private Error responseInfoError(String errorCode) {
        ErrorKey errorKey = new ErrorKey(errorCode);
        iSpainTDError = new Spain_TD_Error_Client();
        ErrorResponse errorResponse = iSpainTDError.search(errorKey);
        Gson gson = new Gson();
        System.out.println(gson.toJson(errorResponse));
        Error error = new Error();
        error.setCod_error("PGIM.0007.E" + errorResponse.getErrorInfo().getErrorCode());
        error.setTexto_error(errorResponse.getErrorInfo().getErrorDescription());
        return error;
    }

    private void generateLogs(final GetProfileRequest getProfileRequest,
                              final UserResponse userResponse,
                              final GetProfileResponse getProfileResponse,
                              final String url,
                              final String instancedId) {
        Map<String, String> indexKey = new HashMap<String, String>();
        logInfoHelpdesk = new LogInfoHelpdesk(getProfileRequest, userResponse, getProfileResponse);
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

}
