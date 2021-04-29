package com.telefonica.gal.client.dynamicrouting.bu.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telefonica.gal.client.dynamicrouting.bu.msg.RoutingBUInfo;
import com.telefonica.gal.client.dynamicrouting.bu.msg.RoutingBUKey;

@Service
public class DynamicRoutingBUClient implements DynamicRoutingBU {

	@Value("${dynamicConfig.unica.bu.uri}")
	private String URI;

	public RoutingBUInfo search(RoutingBUKey tdKey) {
		String dynamicRoutingURL = 
				URI 
				+ "/search?instanceID=" + tdKey.getInstanceID() 
				+ "&platformID=" + tdKey.getPlatformID() 
				+ "&operationType=" + tdKey.getOperationType();

		RestTemplate plantilla = new RestTemplate();

		return plantilla.getForObject(dynamicRoutingURL, RoutingBUInfo.class);

	}

}
