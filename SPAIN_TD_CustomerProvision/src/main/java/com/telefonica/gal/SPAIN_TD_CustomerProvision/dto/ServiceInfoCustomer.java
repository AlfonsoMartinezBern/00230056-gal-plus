package com.telefonica.gal.SPAIN_TD_CustomerProvision.dto;

import java.io.Serializable;

public class ServiceInfoCustomer implements Serializable {
    private String name;

    public ServiceInfoCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
