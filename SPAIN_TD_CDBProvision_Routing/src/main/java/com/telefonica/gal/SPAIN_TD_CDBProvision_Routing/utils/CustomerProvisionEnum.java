package com.telefonica.gal.SPAIN_TD_CDBProvision_Routing.utils;

public enum CustomerProvisionEnum {
    OPERATION_API(0, "UserProvision"),

    SERVICE_API(1, "SPAIN_TD_CustomerProvision"),

    CODE_INTERFACE(2, "CustomerProvision");

    private Integer value;

    private String desc;


    private CustomerProvisionEnum(Integer value, String desc) {
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
