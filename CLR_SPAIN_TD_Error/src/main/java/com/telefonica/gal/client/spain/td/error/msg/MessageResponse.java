package com.telefonica.gal.client.spain.td.error.msg;

public class MessageResponse {
	
	private String result;
	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageResponse{" +
				"result='" + result + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
