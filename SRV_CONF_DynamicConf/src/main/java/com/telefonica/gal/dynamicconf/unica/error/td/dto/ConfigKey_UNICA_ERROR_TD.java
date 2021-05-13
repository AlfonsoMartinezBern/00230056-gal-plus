package com.telefonica.gal.dynamicconf.unica.error.td.dto;

public class ConfigKey_UNICA_ERROR_TD {
	
	private String short_description;
	private String interfaceType;

	public ConfigKey_UNICA_ERROR_TD(String short_description, String interfaceType) {
		this.short_description = short_description;
		this.interfaceType = interfaceType;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	@Override
	public String toString() {
		return "ConfigKey_UNICA_ERROR_TD{" +
				"short_description='" + short_description + '\'' +
				", interfaceType='" + interfaceType + '\'' +
				'}';
	}
}
