package com.telefonica.gal.client.spain.td.error.msg;

public class ErrorKey {
	
	
	private String errorCode;

	


	public ErrorKey(String errorCode) {
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
