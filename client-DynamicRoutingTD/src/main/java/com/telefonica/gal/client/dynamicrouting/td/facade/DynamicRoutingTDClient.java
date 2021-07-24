package com.telefonica.gal.client.dynamicrouting.td.facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;

@Service
public class DynamicRoutingTDClient implements DynamicRoutingTD {

	@Value("${dynamicRouting.uri}")
	private String URI;

	public RoutingTDInfo search(RoutingTDKey tdKey) {
		String dynamicRoutingURL = 
				URI 
				+ "/search?serviceID=" + tdKey.getServiceID() 
				+ "&operationTD=" + tdKey.getOperationTD() 
				+ "&uri=" + tdKey.getUri();

		RestTemplate plantilla = new RestTemplate();
		System.out.println(dynamicRoutingURL);
		return plantilla.getForObject(dynamicRoutingURL, RoutingTDInfo.class);

	}

}
