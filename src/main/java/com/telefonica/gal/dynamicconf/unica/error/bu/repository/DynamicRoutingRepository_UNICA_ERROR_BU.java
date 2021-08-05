package com.telefonica.gal.dynamicconf.unica.error.bu.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.DynamicConfigErrors_DTO;
import com.telefonica.gal.dynamicconf.repository.DynamicConfigRepository;
import com.telefonica.gal.dynamicconf.unica.error.bu.repository.model.Route_UNICA_ERROR_BU;

@Component
public class DynamicRoutingRepository_UNICA_ERROR_BU extends DynamicConfigRepository<DynamicConfigErrors_DTO,Route_UNICA_ERROR_BU> {

	public DynamicRoutingRepository_UNICA_ERROR_BU() {
		super(new DynamicRoutingJSON_UNICA_ERROR_BU());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Route_UNICA_ERROR_BU> getMaps() {
		return getRepository().getErrors();
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
