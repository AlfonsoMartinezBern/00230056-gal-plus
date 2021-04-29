package com.telefonica.gal.dynamicconf.repository;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamicConfigErrors_DTO<T> extends DynamicConfigJSON_DTO {
	 private ArrayList<T> errors;
}
