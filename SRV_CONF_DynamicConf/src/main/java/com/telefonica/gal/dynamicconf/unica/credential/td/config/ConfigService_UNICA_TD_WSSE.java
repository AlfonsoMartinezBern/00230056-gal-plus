package com.telefonica.gal.dynamicconf.unica.credential.td.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.unica.credential.td.repository.DynamicRoutingRepository_UNICA_TD_WSSE;
import com.telefonica.gal.dynamicconf.unica.credential.td.repository.model.Mapper_UNICA_TD_WSSE;

@Component
public class ConfigService_UNICA_TD_WSSE extends ConfigService{
	
	@Autowired
	ConfigService_UNICA_TD_WSSE(@Value("${configFile.unica.credential.td.path}") String path, @Value("${configFile.unica.credential.td.name}") String name,DynamicRoutingRepository_UNICA_TD_WSSE repository,Mapper_UNICA_TD_WSSE routingMapper) {
		super(path + name, repository, routingMapper,DynamicConfType.UNICA_TD_WSSE);
	}

}
