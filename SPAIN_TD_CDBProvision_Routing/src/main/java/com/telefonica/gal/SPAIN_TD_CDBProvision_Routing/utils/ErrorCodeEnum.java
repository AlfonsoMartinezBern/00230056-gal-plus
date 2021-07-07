package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.utils;

public enum ErrorCodeEnum {

    OBLIGATORY_FIELD_CLIENT_SEGMENT_NAME("Parameter [clientSegmentName] not found in the request"),
    FORMAT_ERROR_TRANSACTIONAL_PURCHASES("transactionalPurchases value not valid"),
    FORMAT_ERROR_DOWNLOAD_TO_GO("downloadToGo value not valid"),
    FORMAT_ERROR_MAX_NUM_DEVICES("maxNumDevices value not valid"),
    OBLIGATORY_FIELD_CODE("Parameter [code] is required in subscribedProducts .");

    private String value;

    private ErrorCodeEnum(String value) {
        this.value= value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
