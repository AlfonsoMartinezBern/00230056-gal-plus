package com.telefonica.gal.dynamicconf.unica.error.td.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigInfo_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.dto.ConfigKey_UNICA_ERROR_TD;

@Component
public class MapTable_UNICA_ERROR_TD extends ConfigTableGeneric<ConfigKey_UNICA_ERROR_TD, ConfigInfo_UNICA_ERROR_TD> {

	public MapTable_UNICA_ERROR_TD(@Value("${configFile.unica.error.td.name}") String dynamic_routing_name) {
		super(dynamic_routing_name);
	}

}
