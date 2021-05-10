package com.telefonica.gal.dynamicconf.spain.td.controller;

import com.telefonica.gal.dynamicconf.generic.dto.ConfigTableGeneric;
import com.telefonica.gal.dynamicconf.spain.td.dto.RoutingInfo_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.dto.RoutingKey_SPAIN_TD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoutingTable_SPAIN_TD extends ConfigTableGeneric<RoutingKey_SPAIN_TD, RoutingInfo_SPAIN_TD> {

    public RoutingTable_SPAIN_TD(@Value("${configFile.spain.td.name}") String dynamic_routing_name) {
        super(dynamic_routing_name);
    }
}
