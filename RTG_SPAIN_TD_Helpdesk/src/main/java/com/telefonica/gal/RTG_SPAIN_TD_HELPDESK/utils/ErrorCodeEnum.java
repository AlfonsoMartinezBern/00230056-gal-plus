package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.utils;

public enum ErrorCodeEnum {

    FORMAT_ERROR_CLIENT_IDENTIFIER("GAL-0001"),
    FIELD_FORMAT_ERROR_HYDRA_ORDER("GAL-0002"),
    FORMAT_ERROR_START_DATE("GAL-0003"),
    FORMAT_ERROR_END_DATE("GAL-0004"),
    DATE_INTERVAL_LIMIT_EXCEEDED("GAL-0005"),
    NOT_EXIST_CLIENT_IDENTIFIER("GAL-0006"),
    DATABASE_ERROR("GAL-0007"),
    COMMUNICATIONS_ERROR("GAL-0008"),
    WRONG_END_POINT_RESPONSE("GAL-0009");


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
