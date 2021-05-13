package com.telefonica.gal.dynamicconf.unica.td.facade;

import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.unica.td.config.ConfigService_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.controller.RoutingTable_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingInfo_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingKey_UNICA_TD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamicConfig/unica/td")
public class DynamicRouting_UNICA_TD_Facade extends DynamicConf_Facade {
	

	@Autowired
	public DynamicRouting_UNICA_TD_Facade(ConfigService_UNICA_TD configService, RoutingTable_UNICA_TD routingTable) {
		super(configService, routingTable);
	}

	@GetMapping("/search")
	public RoutingInfo_UNICA_TD getJSON(@RequestParam String serviceID, @RequestParam String operationTD,
			@RequestParam String uri) {
	
		charge();
		
		RoutingKey_UNICA_TD key = new RoutingKey_UNICA_TD(serviceID, operationTD, uri);
		RoutingInfo_UNICA_TD routingInfo = (RoutingInfo_UNICA_TD) getRoutingTable().search(key);
		if(routingInfo==null) {
			return new RoutingInfo_UNICA_TD(null, null);
		}
		return routingInfo;
	}

}
