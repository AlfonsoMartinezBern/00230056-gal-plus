package com.telefonica.gal.dynamicconf.unica.error.bu.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.unica.error.bu.config.ConfigService_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.controller.MapTable_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.dto.ConfigInfo_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.dto.ConfigKey_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigInfo_UNICA_ERROR_TD;

@RestController
@RequestMapping("/dynamicConfig/unica/bu/error")
public class DynamicRouting_UNICA_ERROR_BU_Facade extends DynamicConf_Facade {
	

	@Autowired
	public DynamicRouting_UNICA_ERROR_BU_Facade(ConfigService_UNICA_ERROR_BU configService, MapTable_UNICA_ERROR_BU routingTable) {
		super(configService, routingTable);
	}

	@GetMapping("/search")
	public ConfigInfo_UNICA_ERROR_BU getJSON(@RequestParam String short_description, @RequestParam String interfaceType) {
	
		charge();
		
		ConfigKey_UNICA_ERROR_BU key = new ConfigKey_UNICA_ERROR_BU(short_description, interfaceType);

		ConfigInfo_UNICA_ERROR_BU routingInfo =  (ConfigInfo_UNICA_ERROR_BU) getRoutingTable().search(key);
		
		if(routingInfo==null) {
			return new ConfigInfo_UNICA_ERROR_BU(null);
		}
		return routingInfo;
	}

}
