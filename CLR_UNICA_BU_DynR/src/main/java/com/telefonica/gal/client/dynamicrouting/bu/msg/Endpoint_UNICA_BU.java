package com.telefonica.gal.client.dynamicrouting.bu.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@ToString
public class Endpoint_UNICA_BU{
    
	private String id;

    private String uri;
    
    private String targetEndpoint;
    
    private String wssUser;
    private String wssPassword;
    
    private String alterFlow;
    
    private String endpointType;
    
    
	public boolean existId(String id) {
		return this.id.equals(id);
		
	}
}