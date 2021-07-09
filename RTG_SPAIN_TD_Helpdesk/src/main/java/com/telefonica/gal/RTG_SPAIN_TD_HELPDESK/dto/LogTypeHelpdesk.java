package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.dto;

import java.io.Serializable;

public class LogTypeHelpdesk implements Serializable {
    private String system = "Funtional";
    private String type = "INFO";

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
