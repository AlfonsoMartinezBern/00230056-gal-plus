package com.telefonica.gal.dynamicconf.unica.bu.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.bu.config.ConfigService_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.controller.RoutingTable_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingInfo_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingKey_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.Route_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingInfo_UNICA_TD;

@RestController
@RequestMapping("/dynamicConfig/unica/bu")
public class DynamicRouting_UNICA_BU_Facade extends DynamicConf_Facade {
	

	@Autowired
	public DynamicRouting_UNICA_BU_Facade(ConfigService_UNICA_BU configService, RoutingTable_UNICA_BU routingTable) {
		super(configService, routingTable);
	}

	@GetMapping("/search")
	public RoutingInfo_UNICA_BU getJSON(@RequestParam String instanceID, @RequestParam String platformID,
			@RequestParam String operationType) {
		
		charge();
		
		RoutingKey_UNICA_BU key = new RoutingKey_UNICA_BU(instanceID, platformID, operationType);
		RoutingInfo_UNICA_BU routingInfo =  (RoutingInfo_UNICA_BU) getRoutingTable().search(key);
		
		if(routingInfo==null) {
			return new RoutingInfo_UNICA_BU(null, null);
		}
		return routingInfo;
		
	}

}
