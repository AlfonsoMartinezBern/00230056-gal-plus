package com.telefonica.gal.dynamicconf.repository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DynamicConfigJSON_DTO{
	
	protected String version;
	protected String info;


	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
