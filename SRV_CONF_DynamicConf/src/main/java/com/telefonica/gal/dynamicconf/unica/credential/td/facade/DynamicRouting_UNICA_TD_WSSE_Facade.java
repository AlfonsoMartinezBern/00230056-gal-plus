package com.telefonica.gal.dynamicconf.unica.credential.td.facade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.gal.dynamicconf.facade.DynamicConf_Facade;
import com.telefonica.gal.dynamicconf.unica.credential.td.config.ConfigService_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.controller.MapTable_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.repository.DynamicRoutingJSON_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.repository.model.Credential_UNICA_TD_WSSE;

@RestController
@RequestMapping("/dynamicConfig/unica/td/wsse")
public class DynamicRouting_UNICA_TD_WSSE_Facade extends DynamicConf_Facade<DynamicRoutingJSON_UNICA_TD_WSSE> {
	

	@Autowired
	public DynamicRouting_UNICA_TD_WSSE_Facade(ConfigService_UNICA_TD_WSSE configService, MapTable_UNICA_TD_WSSE routingTable) {
		super(configService, routingTable);
	}

	@GetMapping("/search")
	public ArrayList<Credential_UNICA_TD_WSSE> getJSON() {
		return  getRoutingTable().search();
	}

}
