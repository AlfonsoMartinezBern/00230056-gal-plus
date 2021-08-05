package com.telefonica.gal.dynamicconf.unica.credential.td.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.telefonica.gal.dynamicconf.repository.DynamicConfigCredentials_DTO;
import com.telefonica.gal.dynamicconf.repository.DynamicConfigRepository;
import com.telefonica.gal.dynamicconf.unica.credential.td.repository.model.Credentials_UNICA_TD_WSSE;

@Component
public class DynamicRoutingRepository_UNICA_TD_WSSE extends DynamicConfigRepository<DynamicConfigCredentials_DTO,Credentials_UNICA_TD_WSSE> {

	public DynamicRoutingRepository_UNICA_TD_WSSE() {
		super(new DynamicRoutingJSON_UNICA_TD_WSSE());
	}


	@Override
	public boolean isValid() {
		return DynamicRoutingRepository_UNICA_TD_WSSE_Validator.isValid(repository.getCredentials());
	}


	@Override
	public List<Credentials_UNICA_TD_WSSE> getMaps() {
		return getRepository().getCredentials();
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
