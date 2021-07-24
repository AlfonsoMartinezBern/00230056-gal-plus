package com.telefonica.gal.SPAIN_TD_CDBProvision.utils;

public enum ErrorCodeEnum {

    OBLIGATORY_FIELD_CLIENT_SEGMENT_NAME("SAT-01"),
    FORMAT_ERROR_TRANSACTIONAL_PURCHASES("SAT-02"),
    FORMAT_ERROR_DOWNLOAD_TO_GO("SAT-03"),
    FORMAT_ERROR_MAX_NUM_DEVICES("SAT-04"),
    OBLIGATORY_FIELD_CODE("SAT-05");

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
