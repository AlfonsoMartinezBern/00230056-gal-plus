package com.telefonica.gal.dynamicconf.spain.td.routing.facade;

import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.spain.td.routing.config.ConfigService_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.routing.controller.RoutingTable_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.routing.dto.RoutingInfo_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.routing.dto.RoutingKey_SPAIN_TD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamicConfig/spain/td")
public class DynamicRouting_SPAIN_TD_Facade extends DynamicConf_Facade {

    @Autowired
    public DynamicRouting_SPAIN_TD_Facade(ConfigService_SPAIN_TD configService, RoutingTable_SPAIN_TD routingTable) {
        super(configService, routingTable);
    }

    @GetMapping("/search")
    public RoutingInfo_SPAIN_TD getJSON(@RequestParam String operationTD) {

        charge();

        RoutingKey_SPAIN_TD key = new RoutingKey_SPAIN_TD(operationTD);
        RoutingInfo_SPAIN_TD routingInfo = (RoutingInfo_SPAIN_TD) getRoutingTable().search(key);
        if(routingInfo==null) {
            return new RoutingInfo_SPAIN_TD(null, null);
        }
        return routingInfo;
    }
}
