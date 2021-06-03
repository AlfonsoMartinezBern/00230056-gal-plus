package com.telefonica.gal.client.spain.td.error.msg;

public class ErrorResponse extends MessageResponse{

	private ErrorInfo errorInfo;

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
}
