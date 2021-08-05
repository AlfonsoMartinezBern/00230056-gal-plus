package com.telefonica.gal.dynamicconf.spain.td.error.repository.model;

import com.telefonica.gal.dynamicconf.spain.td.error.dto.ErrorSpainTDInfo;

public class Error_SPAIN_TD_ERROR {

	private String errorCode;
	private String errorCodeInterface;
	private String errorCodeOperation;
	
	private ErrorSpainTDInfo errorInfo;


	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorCodeInterface() {
		return errorCodeInterface;
	}

	public String getErrorCodeOperation() {
		return errorCodeOperation;
	}



	public ErrorSpainTDInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorSpainTDInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorCodeInterface(String errorCodeInterface) {
		this.errorCodeInterface = errorCodeInterface;
	}

	public void setErrorCodeOperation(String errorCodeOperation) {
		this.errorCodeOperation = errorCodeOperation;
	}


	
	

}
