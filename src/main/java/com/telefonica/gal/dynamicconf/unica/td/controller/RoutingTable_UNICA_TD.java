package com.telefonica.gal.dynamicconf.unica.td.controller;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingInfo_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.dto.RoutingKey_UNICA_TD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoutingTable_UNICA_TD extends ConfigTableGeneric<RoutingKey_UNICA_TD, RoutingInfo_UNICA_TD> {

	public RoutingTable_UNICA_TD(@Value("${configFile.unica.td.name}") String dynamic_routing_name) {
		super(dynamic_routing_name);
	}

}
