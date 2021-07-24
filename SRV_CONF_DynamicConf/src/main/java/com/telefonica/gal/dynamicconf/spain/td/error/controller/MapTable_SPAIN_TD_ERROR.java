package com.telefonica.gal.dynamicconf.spain.td.error.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.spain.td.error.dto.ConfigInfo_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.dto.ConfigKey_SPAIN_TD_ERROR;

@Component
public class MapTable_SPAIN_TD_ERROR extends ConfigTableGeneric<ConfigKey_SPAIN_TD_ERROR, ConfigInfo_SPAIN_TD_ERROR> {

	public MapTable_SPAIN_TD_ERROR(@Value("${configFile.spain.td.error.name}") String dynamic_error_name) {
		super(dynamic_error_name);
	}

}
