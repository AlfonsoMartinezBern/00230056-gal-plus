package com.telefonica.gal.dynamicconf.unica.td.config;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.unica.td.repository.DynamicRoutingRepository_UNICA_TD;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Mapper_UNICA_TD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService_UNICA_TD extends ConfigService{
	
	@Autowired
	ConfigService_UNICA_TD(@Value("${configFile.unica.td.path}") String path, @Value("${configFile.unica.td.name}") String name,DynamicRoutingRepository_UNICA_TD repository,Mapper_UNICA_TD routingMapper) {
		super(path + name, repository, routingMapper,DynamicConfType.UNICA_TD_ROUTING);
	}

}
