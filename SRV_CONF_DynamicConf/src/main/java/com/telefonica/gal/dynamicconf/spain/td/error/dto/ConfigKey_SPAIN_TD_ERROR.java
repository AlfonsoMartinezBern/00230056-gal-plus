package com.telefonica.gal.dynamicconf.spain.td.error.dto;

public class ConfigKey_SPAIN_TD_ERROR {
	

	
	private String errorCode;
	private String errorCodeInterface;
	private String errorCodeOperation;
	


	public ConfigKey_SPAIN_TD_ERROR( String errorCode, String errorCodeInterface,
			String errorCodeOperation) {
		super();
	
		this.errorCode = errorCode;
		this.errorCodeInterface = errorCodeInterface;
		this.errorCodeOperation = errorCodeOperation;
	}



	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorCodeInterface() {
		return errorCodeInterface;
	}

	public String getErrorCodeOperation() {
		return errorCodeOperation;
	}

	@Override
	public String toString() {
		return "ErrorKey{" +
				"errorCode='" + errorCode + '\'' +
				"errorCodeInterface='" + errorCodeInterface + '\'' +
				"errorCodeOperation='" + errorCodeOperation + '\'' +
				"}";
	}

	

	

}


