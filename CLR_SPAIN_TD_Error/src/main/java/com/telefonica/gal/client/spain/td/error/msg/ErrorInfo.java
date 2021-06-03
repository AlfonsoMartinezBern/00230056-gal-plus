package com.telefonica.gal.client.spain.td.error.msg;

public class ErrorInfo {
	
	private String errorCode;
	private String errorDescription;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
//	@Override
//	public String toString() {
//		return "MessageResponse{" +
//				"errorCode='" + this.getErrorCode() + '\'' +
//				", errorDescription='" + this.getErrorDescription() + '\'' +
//				", result='" + this.getResult() + '\'' +
//				", message='" + this.getMessage() + '\'' +
//				'}';
//	}
	
}
