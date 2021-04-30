package com.telefonica.gal.client.dynamicrouting.td.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Flow{
	
    private int step;
    private String endpointID;
    private String type;
    private boolean active;
    private boolean synchronous;

    
}
