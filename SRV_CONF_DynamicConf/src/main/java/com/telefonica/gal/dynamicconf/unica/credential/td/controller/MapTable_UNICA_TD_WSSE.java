package com.telefonica.gal.dynamicconf.unica.credential.td.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.credential.td.dto.ConfigInfo_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.dto.ConfigKey_UNICA_TD_WSSE;

@Component
public class MapTable_UNICA_TD_WSSE extends ConfigTableGeneric<ConfigKey_UNICA_TD_WSSE, ConfigInfo_UNICA_TD_WSSE> {

	public MapTable_UNICA_TD_WSSE(@Value("${configFile.unica.credential.td.name}") String configFileName) {
		super(configFileName);
	}

}
