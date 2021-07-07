package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.validator;


import com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.utils.ErrorCodeEnum;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.exceptions.ErrorMessage;
import com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.exceptions.HelpdeskException;
import com.telefonica.gal.wsdl.getProfile.GetProfileRequest;

public class HelpdeskValidator {
    public void isValid(GetProfileRequest getProfileRequest) throws ErrorMessage {

        String orden_hidra = getProfileRequest.getOrden_hidra();
        String cod_admin = getProfileRequest.getCod_admin();

        // orden_hidra
        if (orden_hidra.isEmpty() || orden_hidra.isBlank() || orden_hidra == null)
            throw new HelpdeskException().getErrorInfo(ErrorCodeEnum.FIELD_FORMAT_ERROR_HYDRA_ORDER.getValue() , orden_hidra);

        // cod_admin
        if (cod_admin.isEmpty() || cod_admin.isBlank() || cod_admin == null)
            throw new HelpdeskException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_CLIENT_IDENTIFIER.getValue(), orden_hidra);
        if (!cod_admin.matches("[\\p{ASCII}&&[^\\x5F]]{1,32}"))
            throw new HelpdeskException().getErrorInfo(ErrorCodeEnum.FORMAT_ERROR_CLIENT_IDENTIFIER.getValue(), orden_hidra);

    }

}
