package com.telefonica.gal.client.spain.td.error.msg;

public class ErrorKey {
	
	private String operationApi;
	private String serviceApi;
	
	private String errorCode;
	private String errorCodeInterface;
	private String errorCodeOperation;
	


	public ErrorKey(String operationApi, String serviceApi, String errorCode, String errorCodeInterface,
			String errorCodeOperation) {
		super();
		this.operationApi = operationApi;
		this.serviceApi = serviceApi;
		this.errorCode = errorCode;
		this.errorCodeInterface = errorCodeInterface;
		this.errorCodeOperation = errorCodeOperation;
	}

	public String getOperationApi() {
		return operationApi;
	}

	public String getServiceApi() {
		return serviceApi;
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
				"operationApi='" + operationApi + '\'' +
				"serviceApi='" + serviceApi + '\'' +
				"errorCode='" + errorCode + '\'' +
				"errorCodeInterface='" + errorCodeInterface + '\'' +
				"errorCodeOperation='" + errorCodeOperation + '\'' +
				"}";
	}

	

	

}
