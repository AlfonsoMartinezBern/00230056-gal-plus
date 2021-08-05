package com.telefonica.gal.dynamicconf.unica.bu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.unica.bu.repository.DynamicRoutingRepository_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.RoutingMapper_UNICA_BU;

@Component
public class ConfigService_UNICA_BU extends ConfigService{
	
	@Autowired
	ConfigService_UNICA_BU(@Value("${configFile.unica.bu.path}") String path, @Value("${configFile.unica.bu.name}") String name,DynamicRoutingRepository_UNICA_BU repository,RoutingMapper_UNICA_BU routingMapper) {
		super(path + name, repository, routingMapper,DynamicConfType.UNICA_BU_ROUTING);
	}

}
