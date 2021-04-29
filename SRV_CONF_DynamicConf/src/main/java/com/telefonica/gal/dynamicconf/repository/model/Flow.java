package com.telefonica.gal.dynamicconf.repository.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flow{
    private int step;
    private String endpointID;
    private String type;
    private boolean active;
    private boolean synchronous;
    
}
