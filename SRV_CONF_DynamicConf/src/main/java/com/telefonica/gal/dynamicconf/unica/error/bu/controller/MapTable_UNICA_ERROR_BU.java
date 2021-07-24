package com.telefonica.gal.dynamicconf.unica.error.bu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.error.bu.dto.ConfigInfo_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.dto.ConfigKey_UNICA_ERROR_BU;

@Component
public class MapTable_UNICA_ERROR_BU extends ConfigTableGeneric<ConfigKey_UNICA_ERROR_BU, ConfigInfo_UNICA_ERROR_BU> {

	
	
	public MapTable_UNICA_ERROR_BU(@Value("${configFile.unica.error.bu.name}") String dynamic_routing_name) {
		super(dynamic_routing_name);
	}

}
