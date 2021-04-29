package com.telefonica.gal.dynamicconf.config;

import com.telefonica.gal.dynamicconf.facade.DynamicConfType;
import com.telefonica.gal.dynamicconf.repository.Repository;
import com.telefonica.gal.dynamicconf.repository.model.ConfigMapper;

public class ConfigService {

	


	private DynamicConfType dynRoutType;
	
	private String configFile;
	
	private Repository repository;
	
	private ConfigMapper routingMapper;

	protected ConfigService(String configFile,Repository repository,ConfigMapper routingMapper,DynamicConfType dynRoutType) {
		super();
		this.configFile = configFile;
		this.repository = repository;
		this.routingMapper = routingMapper;
		this.dynRoutType = dynRoutType;
	}
	
	
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
		this.chargeConf();

	}
	
	public Repository getRepository() {
		return repository;
	}


	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public boolean isValidChargeConf() {
		repository.getConfFromJSON(configFile);
		if (repository == null) {
			return false;
		}
		return repository.isValid();
	}
	
	
	public boolean chargeConf() {
		repository.getConfFromJSON(configFile);
		
		if (repository == null) {
			return false;
		}
		return routingMapper.parse2Dto(repository);
	}


	public DynamicConfType getDynRoutType() {
		return dynRoutType;
	}


	public String getConfigFile() {
		return configFile;
	}

}
