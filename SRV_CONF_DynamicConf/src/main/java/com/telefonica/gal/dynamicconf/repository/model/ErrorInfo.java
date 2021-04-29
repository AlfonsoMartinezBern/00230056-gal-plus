package com.telefonica.gal.dynamicconf.repository.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorInfo{
    private String error_code;
    private String long_description;
    private String message;
    private String severity;
    private String solution;
    private String validation;
    private String source;
    private String exception_id;
    private String exception_desc;
    

    
}
