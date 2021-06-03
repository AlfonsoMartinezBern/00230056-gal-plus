package com.telefonica.gal.client.spain.td.error.msg;

public class ErrorInfo extends MessageResponse{
	String errorCode;
	String errorDescription;

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


	@Override
	public String toString() {
		return "ErrorInfo{" +
				"errorCode='" + errorCode + '\'' +
				", errorDescription='" + errorDescription + '\'' +
				'}';
	}
}
