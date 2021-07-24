package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.utils;

public enum HelpdeskEnum {
    OPERATION_API(0, "UserProvision"),

    SERVICE_API(1, "SPAIN_TD_CustomerProvision"),

    CODE_INTERFACE(2, "CustomerProvision");

    private Integer value;

    private String desc;


    private HelpdeskEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
