package com.telefonica.gal.dynamicconf.repository;

import java.util.ArrayList;

public class DynamicConfigErrors_DTO<T> extends DynamicConfigJSON_DTO {

	 private ArrayList<T> errors;

	public ArrayList<T> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<T> errors) {
		this.errors = errors;
	}
}
