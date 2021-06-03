package com.telefonica.gal.dynamicconf.spain.td.routing.repository;

import com.telefonica.gal.dynamicconf.repository.DynamicConfigRepository;
import com.telefonica.gal.dynamicconf.repository.DynamicConfigRoutes_DTO;
import com.telefonica.gal.dynamicconf.spain.td.routing.repository.model.Route_SPAIN_TD;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DynamicRoutingRepository_SPAIN_TD extends DynamicConfigRepository<DynamicConfigRoutes_DTO, Route_SPAIN_TD> {

    public DynamicRoutingRepository_SPAIN_TD() {
        super(new DynamicRoutingJSON_SPAIN_TD());
    }

    @Override
    public boolean isValid() {
        return DynamicRoutingRepository_SPAIN_TD_Routes_Validator.isValid(getRepository().getRoutes());
    }


    @Override
    public List<Route_SPAIN_TD> getMaps() {
        return getRepository().getRoutes();
    }

    @Override
    public String getVersion() {
        return getRepository().getVersion();
    }

    @Override
    public String getInfo() {
        return getRepository().getInfo();
    }
}