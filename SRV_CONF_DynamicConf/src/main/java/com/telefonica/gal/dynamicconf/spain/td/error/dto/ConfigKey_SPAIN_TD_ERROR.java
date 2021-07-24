package com.telefonica.gal.dynamicconf.spain.td.error.dto;

public class ConfigKey_SPAIN_TD_ERROR {
	

	
	private String errorCode;
	


	public ConfigKey_SPAIN_TD_ERROR( String errorCode) {
		super();
	
		this.errorCode = errorCode;
	
	}



	public String getErrorCode() {
		return errorCode;
	}



	@Override
	public String toString() {
		return "ErrorKey{" +
				"errorCode='" + errorCode + '\'' +
				
				"}";
	}

	

	

}


