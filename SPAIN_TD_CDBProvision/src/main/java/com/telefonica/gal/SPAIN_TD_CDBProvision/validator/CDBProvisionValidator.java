package com.telefonica.gal.SPAIN_TD_CDBProvision.validator;


import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.CustomerException;
import com.telefonica.gal.SPAIN_TD_CDBProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CDBProvision.utils.ErrorCodeEnum;
import com.telefonica.gal.provisionApi.model.CDBProvisionRequest;
import com.telefonica.gal.provisionApi.model.SubscribedProduct;

public class CDBProvisionValidator {

    public void isValid(CDBProvisionRequest cdbProvisionRequest) throws ErrorMessage {

        Integer resultCode = 40001;
        String prueba = cdbProvisionRequest.getClientSegmentName();
        if (cdbProvisionRequest.getClientSegmentName() == null)
            throw new CustomerException().getErrorInfo(resultCode, ErrorCodeEnum.OBLIGATORY_FIELD_CLIENT_SEGMENT_NAME.getValue(), "Bad request.");
        if (cdbProvisionRequest.getClientSegmentName().isEmpty() || cdbProvisionRequest.getClientSegmentName().isBlank() || cdbProvisionRequest.getClientSegmentName().equals("")) {
            throw new CustomerException().getErrorInfo(resultCode, ErrorCodeEnum.OBLIGATORY_FIELD_CLIENT_SEGMENT_NAME.getValue(), "Bad request.");

        }

        // Formato clientSegmentName
        if (cdbProvisionRequest.getServiceFlags() != null) {
            if (cdbProvisionRequest.getServiceFlags().getTransactionalPurchases() != null) {
                cdbProvisionRequest.getServiceFlags().getTransactionalPurchases();
                if (Integer.valueOf(cdbProvisionRequest.getServiceFlags().getTransactionalPurchases().toString()) != 0
                        && Integer.valueOf(cdbProvisionRequest.getServiceFlags().getTransactionalPurchases().toString()) != 1)
                    throw new CustomerException().getErrorInfo(resultCode, ErrorCodeEnum.FORMAT_ERROR_TRANSACTIONAL_PURCHASES.getValue(), "Bad request.");
            }

            if (cdbProvisionRequest.getServiceFlags().getDownloadToGo() != null) {
                if (Integer.valueOf(cdbProvisionRequest.getServiceFlags().getDownloadToGo().toString()) != 0
                        && Integer.valueOf(cdbProvisionRequest.getServiceFlags().getDownloadToGo().toString()) != 1)
                    throw new CustomerException().getErrorInfo(resultCode, ErrorCodeEnum.FORMAT_ERROR_DOWNLOAD_TO_GO.getValue(), "Bad request.");
            }

        }

        if (cdbProvisionRequest.getDevices() != null && cdbProvisionRequest.getDevices().getMaxNumDevices() != null) {
            if (cdbProvisionRequest.getDevices().getMaxNumDevices() < -1 ||
                cdbProvisionRequest.getDevices().getMaxNumDevices() > 99)
                throw new CustomerException().getErrorInfo(resultCode, ErrorCodeEnum.FORMAT_ERROR_MAX_NUM_DEVICES.getValue(), "Bad request.");
        }

        if (cdbProvisionRequest.getSubscribedProducts() != null) {
            for (SubscribedProduct subscribedProduct : cdbProvisionRequest.getSubscribedProducts()) {
                if (subscribedProduct.getCode() == null || subscribedProduct.getCode().isBlank() || subscribedProduct.getCode().isEmpty())
                    throw new CustomerException().getErrorInfo(resultCode, ErrorCodeEnum.OBLIGATORY_FIELD_CODE.getValue(), "Bad request.");
            }
        }
    }

}
