package com.telefonica.gal.utils;

public enum ErrorCodeEnum {

    FORMAT_ERROR_OPERATION_ID("GAL-200"),
    OBLIGATORY_FIELD_OPERATION_ID("GAL-201"),
    FORMAT_ERROR_USER_ID("GAL-202"),
    OBLIGATORY_FIELD_USER_ID("GAL-203"),
    FORMAT_ERROR_TV_SERVICE_ID("GAL-204"),
    OBLIGATORY_FIELD_TV_SERVICE_ID("GAL-205"),
    OBLIGATORY_FIELD_VOD_SERVICE_ID("GAL-208"),
    FORMAT_ERROR_TV_SERVICE_OPER("GAL-206"),
    FORMAT_ERROR_VOD_SERVICE_OPER("51");

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
