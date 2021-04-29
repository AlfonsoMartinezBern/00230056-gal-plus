package com.telefonica.gal.dynamicconf.repository;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamicConfigCredentials_DTO<T> extends DynamicConfigJSON_DTO {
	 private ArrayList<T> credentials;
}
