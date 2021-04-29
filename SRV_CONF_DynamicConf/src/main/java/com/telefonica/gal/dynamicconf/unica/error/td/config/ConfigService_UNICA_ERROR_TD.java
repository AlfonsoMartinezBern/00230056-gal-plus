package com.telefonica.gal.dynamicconf.unica.error.td.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.unica.error.td.repository.DynamicRoutingRepository_UNICA_ERROR_TD;
import com.telefonica.gal.dynamicconf.unica.error.td.repository.model.Mapper_UNICA_ERROR_TD;

@Component
public class ConfigService_UNICA_ERROR_TD extends ConfigService{
	
	@Autowired
	ConfigService_UNICA_ERROR_TD(@Value("${configFile.unica.error.td.path}") String path, @Value("${configFile.unica.error.td.name}") String name,DynamicRoutingRepository_UNICA_ERROR_TD repository,Mapper_UNICA_ERROR_TD routingMapper) {
		super(path + name, repository, routingMapper,DynamicConfType.UNICA_ERROR_TD_ROUTING);
	}

}
