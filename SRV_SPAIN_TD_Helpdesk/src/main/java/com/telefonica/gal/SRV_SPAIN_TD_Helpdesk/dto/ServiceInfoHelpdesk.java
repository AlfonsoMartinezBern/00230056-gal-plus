package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.dto;

import java.io.Serializable;

public class ServiceInfoHelpdesk implements Serializable {
    private String name;

    public ServiceInfoHelpdesk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
