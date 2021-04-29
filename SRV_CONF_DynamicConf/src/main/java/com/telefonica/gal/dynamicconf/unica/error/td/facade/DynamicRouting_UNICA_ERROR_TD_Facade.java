package com.telefonica.gal.dynamicconf.unica.error.td.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingInfo_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.error.td.config.ConfigService_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.controller.MapTable_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigInfo_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigKey_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.repository.model.Route_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingInfo_UNICA_TD;

@RestController
@RequestMapping("/dynamicConfig/unica/td/error")
public class DynamicRouting_UNICA_ERROR_TD_Facade extends DynamicConf_Facade {
	

	@Autowired
	public DynamicRouting_UNICA_ERROR_TD_Facade(ConfigService_UNICA_ERROR_TD configService, MapTable_UNICA_ERROR_TD routingTable) {
		super(configService, routingTable);
	}

	@GetMapping("/search")
	public ConfigInfo_UNICA_ERROR_TD getJSON(@RequestParam String short_description, @RequestParam String interfaceType) {
	
		ConfigKey_UNICA_ERROR_TD key = new ConfigKey_UNICA_ERROR_TD(short_description, interfaceType);
		ConfigInfo_UNICA_ERROR_TD routingInfo =  (ConfigInfo_UNICA_ERROR_TD) getRoutingTable().search(key);
		
		if(routingInfo==null) {
			return new ConfigInfo_UNICA_ERROR_TD(null);
		}
		return routingInfo;
	}

}
