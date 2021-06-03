package com.telefonica.gal.dynamicconf.spain.td.error.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.spain.td.error.repository.DynamicConfigRepository_SPAIN_TD_ERROR;
import com.telefonica.gal.dynamicconf.spain.td.error.repository.model.Mapper_SPAIN_TD_ERROR;

@Component
public class ConfigService_SPAIN_TD_ERROR extends ConfigService{
	
	@Autowired
	ConfigService_SPAIN_TD_ERROR(@Value("${configFile.spain.td.error.path}") String path, @Value("${configFile.spain.td.error.name}") String name,DynamicConfigRepository_SPAIN_TD_ERROR repository,Mapper_SPAIN_TD_ERROR routingMapper) {
		super(path + name, repository, routingMapper,DynamicConfType.SPAIN_TD_ERROR);
	}

}
