package com.telefonica.gal.dynamicconf.unica.td.repository;

import com.telefonica.gal.dynamicconf.repository.DynamicConfigRepository;
import com.telefonica.gal.dynamicconf.repository.DynamicConfigRoutes_DTO;
import com.telefonica.gal.dynamicconf.unica.td.repository.model.Route_UNICA_TD;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DynamicRoutingRepository_UNICA_TD extends DynamicConfigRepository<DynamicConfigRoutes_DTO,Route_UNICA_TD> {

	public DynamicRoutingRepository_UNICA_TD() {
		super(new DynamicRoutingJSON_UNICA_TD());
	}


	@Override
	public boolean isValid() {

		return DynamicRoutingRepository_UNICA_TD_Routes_Validator.isValid(getRepository().getRoutes());
	}


	@Override
	public List<Route_UNICA_TD> getMaps() {
		return getRepository().getRoutes();
	}


	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return getRepository().getVersion();
	}


	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return getRepository().getInfo();
	}


	

}
