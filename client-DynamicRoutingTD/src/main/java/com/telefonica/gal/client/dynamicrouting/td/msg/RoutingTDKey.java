package com.telefonica.gal.client.dynamicrouting.td.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoutingTDKey {
	
	private String serviceID;
	private String operationTD;
	private String uri;
	
	public RoutingTDKey(String serviceID, String operationTD, String uri) {
		this.serviceID = serviceID;
		this.operationTD = operationTD;
		this.uri = uri;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		
	if(getClass() != obj.getClass()) {
		return false;
	}
	RoutingTDKey key = (RoutingTDKey) obj;
	if(this.serviceID==key.serviceID && this.operationTD == key.operationTD && this.uri == key.uri) {
		return true;
	}
		return false;
	}

	

}
