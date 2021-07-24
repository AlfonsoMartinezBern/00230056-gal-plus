package com.telefonica.gal.dynamicconf.unica.bu.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.DynamicConfigRepository;
import com.telefonica.gal.dynamicconf.repository.DynamicConfigRoutes_DTO;
import com.telefonica.gal.dynamicconf.unica.bu.repository.model.Route_UNICA_BU;
import com.telefonica.gal.dynamicconf.unica.td.repository.DynamicRoutingJSON_UNICA_TD;

@Component
public class DynamicRoutingRepository_UNICA_BU extends DynamicConfigRepository<DynamicConfigRoutes_DTO,Route_UNICA_BU> {

	public DynamicRoutingRepository_UNICA_BU() {
		super(new DynamicRoutingJSON_UNICA_BU());
	}

	@Override
	public boolean isValid() {
		return DynamicRoutingRepository_UNICA_BU_Validator.isValid(getRepository().getRoutes());
	
	}

	@Override
	public List<Route_UNICA_BU> getMaps() {
		return getRepository().getRoutes();
	}

	@Override
	public String getVersion() {
		return repository.getVersion();
	}

	@Override
	public String getInfo() {
		return repository.getInfo();
	}

	

}
