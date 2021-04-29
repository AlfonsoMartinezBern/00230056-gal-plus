package com.telefonica.gal.dynamicconf.repository.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Errors{
    private String short_description;
    private String interfaceType;
    private ErrorInfo errorInfo;     
}
