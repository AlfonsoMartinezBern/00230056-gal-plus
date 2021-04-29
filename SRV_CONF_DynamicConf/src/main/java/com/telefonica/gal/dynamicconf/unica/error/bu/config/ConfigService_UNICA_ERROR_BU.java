package com.telefonica.gal.dynamicconf.unica.error.bu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.unica.error.bu.repository.DynamicRoutingRepository_UNICA_ERROR_BU;
import com.telefonica.gal.dynamicconf.unica.error.bu.repository.model.Mapper_UNICA_ERROR_BU;

@Component
public class ConfigService_UNICA_ERROR_BU extends ConfigService{
	
	@Autowired
	ConfigService_UNICA_ERROR_BU(@Value("${configFile.unica.error.bu.path}") String path, @Value("${configFile.unica.error.bu.name}") String name,DynamicRoutingRepository_UNICA_ERROR_BU repository,Mapper_UNICA_ERROR_BU mapper) {
		super(path + name, repository, mapper,DynamicConfType.UNICA_ERROR_BU_ROUTING);
	}

}
