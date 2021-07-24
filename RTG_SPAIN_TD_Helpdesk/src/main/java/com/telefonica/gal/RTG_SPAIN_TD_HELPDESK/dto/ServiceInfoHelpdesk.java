package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto;

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
