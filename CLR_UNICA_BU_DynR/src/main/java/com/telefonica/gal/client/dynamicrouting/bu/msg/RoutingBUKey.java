package com.telefonica.gal.client.dynamicrouting.bu.msg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoutingBUKey {
	
	private String instanceID;
	private String platformID;
	private String operationType;
	
	public RoutingBUKey(String instanceID, String platformID, String operationType) {
		this.instanceID = instanceID;
		this.platformID = platformID;
		this.operationType = operationType;
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
	RoutingBUKey key = (RoutingBUKey) obj;
	if(this.instanceID==key.instanceID && this.platformID == key.platformID && this.operationType == key.operationType) {
		return true;
	}
		return false;
	}

	

}
