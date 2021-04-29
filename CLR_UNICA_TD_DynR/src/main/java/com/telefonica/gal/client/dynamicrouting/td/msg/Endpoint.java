package com.telefonica.gal.client.dynamicrouting.td.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@ToString
public class Endpoint{
	
    private String id;
    private int instanceID;
    private int platformID;
    private String targetEndpoint;
    private String alterFlow;
    private String endpointType;
    
	
}