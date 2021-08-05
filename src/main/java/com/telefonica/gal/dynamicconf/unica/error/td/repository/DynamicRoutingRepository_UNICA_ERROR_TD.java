package com.telefonica.gal.dynamicconf.unica.error.td.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.DynamicConfigErrors_DTO;
import com.telefonica.gal.dynamicconf.repository.DynamicConfigRepository;
import com.telefonica.gal.dynamicconf.unica.error.td.repository.model.Route_UNICA_ERROR_TD;

@Component
public class DynamicRoutingRepository_UNICA_ERROR_TD extends DynamicConfigRepository<DynamicConfigErrors_DTO,Route_UNICA_ERROR_TD> {

	public DynamicRoutingRepository_UNICA_ERROR_TD() {
		super(new DynamicRoutingJSON_UNICA_ERROR_TD());
	}


	@Override
	public boolean isValid() {
		return true;
//		return DynamicRoutingRepository_UNICA_ERROR_TD_Routes_Validator.isValid(getCre);
	}


	@Override
	public List<Route_UNICA_ERROR_TD> getMaps() {
		return getRepository().getErrors();
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
