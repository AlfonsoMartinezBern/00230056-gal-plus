package com.telefonica.gal.dto;

import java.io.Serializable;

public class ServiceInfoDto implements Serializable {
    private String name;

    public ServiceInfoDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
