package com.telefonica.gal.client.spain.td.error.msg;

public class ErrorKey {
	
	private String operation;
	
	private String errorCode;
	private String errorCodeInterface;
	private String errorCodeOperation;
	

	public ErrorKey(String operation, String errorCode, String errorCodeInterface, String errorCodeOperation) {
		super();
		this.operation = operation;
		this.errorCode = errorCode;
		this.errorCodeInterface = errorCodeInterface;
		this.errorCodeOperation = errorCodeOperation;
	}

	public String getOperation() {
		return operation;
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
				"operation='" + operation + '\'' +
				"errorCode='" + errorCode + '\'' +
				"errorCodeInterface='" + errorCodeInterface + '\'' +
				"errorCodeOperation='" + errorCodeOperation + '\'' +
				"}";
	}

	

	

}
