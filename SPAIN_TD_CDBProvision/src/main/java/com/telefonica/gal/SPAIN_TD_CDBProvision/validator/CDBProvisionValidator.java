package com.telefonica.gal.SPAIN_TD_CDBProvision.validator;


import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.CustomerException;
import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.ErrorMessage;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;

public class CDBProvisionValidator {

    public void isValid(String adminCode, CDBProvisionRequest cdbProvisionRequest) throws ErrorMessage {

        if (cdbProvisionRequest.getClientSegmentName().equals(null))
            throw new CustomerException().getErrorInfo("0", adminCode, null);
        // Formato clientSegmentName

        if (cdbProvisionRequest.getServiceFlags() == null)
            throw new CustomerException().getErrorInfo("0", adminCode, null);

        if (cdbProvisionRequest.getServiceFlags().getTransactionalPurchases() == null)
            throw new CustomerException().getErrorInfo("0", adminCode, null);
        if (Integer.valueOf(cdbProvisionRequest.getServiceFlags().getTransactionalPurchases().toString()) != 0 && Integer.valueOf(cdbProvisionRequest.getServiceFlags().getTransactionalPurchases().toString()) != 1)
            throw new CustomerException().getErrorInfo("0", adminCode, null);

        if (cdbProvisionRequest.getServiceFlags().getDownloadToGo() == null)
            throw new CustomerException().getErrorInfo("0", adminCode, null);
        if (Integer.valueOf(cdbProvisionRequest.getServiceFlags().getDownloadToGo().toString()) != 0 && Integer.valueOf(cdbProvisionRequest.getServiceFlags().getDownloadToGo().toString()) != 1)
            throw new CustomerException().getErrorInfo("0", adminCode, null);

        if (cdbProvisionRequest.getDevices() == null) throw new CustomerException().getErrorInfo("0", adminCode, null);

        if (cdbProvisionRequest.getDevices().getMaxNumDevices() == null)
            throw new CustomerException().getErrorInfo("0", adminCode, null);
        if (cdbProvisionRequest.getDevices().getMaxNumDevices() > 99)
            throw new CustomerException().getErrorInfo("0", adminCode, null);
    }

}
