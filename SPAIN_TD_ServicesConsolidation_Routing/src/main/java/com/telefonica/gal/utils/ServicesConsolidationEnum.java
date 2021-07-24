package com.telefonica.gal.utils;

public enum ServicesConsolidationEnum {

    OPERATION_API(0, "UserProductsManagement"),

    SERVICE_API(1, "SPAIN_TD_ServicesConsolidation"),

    CODE_INTERFACE(2, "ServicesConsolidation");

    private Integer value;

    private String desc;


    private ServicesConsolidationEnum(Integer value, String desc) {
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
