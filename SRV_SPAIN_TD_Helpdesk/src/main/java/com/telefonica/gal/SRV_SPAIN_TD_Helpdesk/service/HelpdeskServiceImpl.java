package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.service;

import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.factory.FactoryTD;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.dto.LogHelpdesk;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.dto.ServiceInfoHelpdesk;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.exceptions.ErrorMessage;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.validator.HelpdeskValidator;
import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.wsdl.getProfile.*;
import com.telefonica.gal.wsdl.getProfile.Error;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HelpdeskServiceImpl implements HelpdeskService {

    private static Logger loggerWithCustomLayout = LogManager.getLogger("LOGS_HELPDESK_V1");

    private ServiceInfoHelpdesk serviceInfoDto = new ServiceInfoHelpdesk("SRV_SPAIN_TD_Helpdesk");

    private static final String Helpdesk = "Helpdesk";

    private ISpainDynamicRoutingTD dynamicRoutingTD;

    private FactoryTD factoryTD;

    private HelpdeskValidator helpdeskValidator = new HelpdeskValidator();

    public HelpdeskServiceImpl(ISpainDynamicRoutingTD dynamicRoutingTD, FactoryTD factoryTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
        this.factoryTD = factoryTD;
    }


    @Override
    public GetProfileResponse getProfile(GetProfileRequest getProfileRequest) {
        try {
            // Validation
            helpdeskValidator.isValid(getProfileRequest);
            System.out.println("System request is Valid");

            // OP+ and MiView routing info
            RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(new RoutingTDKey(Helpdesk));

            // OP+ and MiView response
            GetProfileResponse getProfileResponse = factoryTD.invokeWs(routingTDInfo, getProfileRequest, null);

            return getProfileResponse;

        } catch (ErrorMessage errorMessage) {
            System.out.println("System request is not valid");
            Error error = new Error();
            error.setCod_error("PGIM.0007.E" + errorMessage.getCodError());
            error.setTexto_error(errorMessage.getMessage());

            HidraTypeResult hidraTypeResult = new HidraTypeResult();
            hidraTypeResult.setError(error);

            GetProfileResponse response = new GetProfileResponse();

            response.setHidra_type_result(hidraTypeResult);
            response.setOrden_hidra(errorMessage.getOrden_hidra());


            LogHelpdesk logHelpdesk = new LogHelpdesk();
            logHelpdesk.setIdLog(UUID.randomUUID().toString());
            logHelpdesk.setServiceInfo(serviceInfoDto);
            logHelpdesk.setMessage(errorMessage.getMessage());
            loggerWithCustomLayout.error(logHelpdesk);

            return response;
        }
    }
}
