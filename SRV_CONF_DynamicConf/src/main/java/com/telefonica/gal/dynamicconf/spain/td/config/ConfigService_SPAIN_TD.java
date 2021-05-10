package com.telefonica.gal.dynamicconf.spain.td.config;

import com.telefonica.gal.dynamicconf.config.ConfigService;
import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.spain.td.repository.DynamicRoutingRepository_SPAIN_TD;
import com.telefonica.gal.dynamicconf.spain.td.repository.model.Mapper_SPAIN_TD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService_SPAIN_TD extends ConfigService {

    @Autowired
    ConfigService_SPAIN_TD(@Value("${configFile.spain.td.path}") String path, @Value("${configFile.spain.td.name}")
            String name, DynamicRoutingRepository_SPAIN_TD repository, Mapper_SPAIN_TD routingMapper) {
        super(path + name, repository, routingMapper,DynamicConfType.SPAIN_TD_ROUTING);
    }

}
