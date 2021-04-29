package com.telefonica.gal.dynamicconf.repository;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamicConfigRoutes_DTO<T> extends DynamicConfigJSON_DTO {
	private ArrayList<T> routes;

}
