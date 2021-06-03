package com.telefonica.gal.dynamicconf.spain.td.error.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.spain.td.error.config.ConfigService_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.controller.MapTable_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.dto.ConfigInfo_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.dto.ConfigKey_SPAIN_TD_ERROR;

@RestController
@RequestMapping("/dynamicConfig/spain/td/error")
public class DynamicRouting_SPAIN_TD_ERROR_Facade extends DynamicConf_Facade {
	

	@Autowired
	public DynamicRouting_SPAIN_TD_ERROR_Facade(ConfigService_SPAIN_TD_ERROR configService, MapTable_SPAIN_TD_ERROR routingTable) {
		super(configService, routingTable);
	}

	@GetMapping("/search")
	public ConfigInfo_SPAIN_TD_ERROR getJSON(@RequestParam String operationApi, @RequestParam String serviceApi,@RequestParam String errorCode, @RequestParam String errorCodeInterface, @RequestParam String errorCodeOperation) {
	
		charge();
		
		ConfigKey_SPAIN_TD_ERROR key = new ConfigKey_SPAIN_TD_ERROR(operationApi, serviceApi, errorCode, errorCodeInterface, errorCodeOperation);
		ConfigInfo_SPAIN_TD_ERROR routingInfo =  (ConfigInfo_SPAIN_TD_ERROR) getRoutingTable().search(key);
		
		if(routingInfo==null) {
			return new ConfigInfo_SPAIN_TD_ERROR(null);
		}
		return routingInfo;
	}

}
