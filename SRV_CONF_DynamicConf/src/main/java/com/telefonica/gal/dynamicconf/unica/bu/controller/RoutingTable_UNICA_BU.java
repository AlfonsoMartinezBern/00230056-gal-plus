package com.telefonica.gal.dynamicconf.unica.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.bu.config.ConfigService_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingInfo_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.dto.RoutingKey_UNICA_BU;

@Component
public class RoutingTable_UNICA_BU extends ConfigTableGeneric<RoutingKey_UNICA_BU, RoutingInfo_UNICA_BU> {

	
	
	public RoutingTable_UNICA_BU(@Value("${configFile.unica.bu.name}") String dynamic_routing_name) {
		super(dynamic_routing_name);
	}

}
