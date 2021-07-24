package com.telefonica.gal.dynamicrouting.dto;

public class MessageResponse {
	
	private String result;
	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public String getResult() {
		return result;
	}
	
	public MessageResponse(String result,String message) {
		super();
		this.result = result;
		this.message = message;
		
	}

	
	
	
	

}
